public class EnumConstantsMetadataContributor implements MetadataContributor {
    private final static Logger LOG = LoggerFactory.getLogger(EnumConstantsMetadataContributor.class);

    private final static List<String> ENABLED_ON = Arrays.asList("validate", "update", "create", "create-drop");
    private final static Integer DEFAULT_VARCHAR_SIZE = 255;
    private final static Identifier DEFAULT_COLUMN_NAME = Identifier.toIdentifier("enum_constant", false);

    @Override
    public void contribute(InFlightMetadataCollector metadataCollector, IndexView jandexIndex) {
        if (shouldRun(metadataCollector)) {
            addEnumsAsTableConstantsAndFkConstraint(metadataCollector);
        }
    }

    private boolean shouldRun(InFlightMetadataCollector metadataCollector) {
        StandardServiceRegistry serviceRegistry = metadataCollector.getMetadataBuildingOptions().getServiceRegistry();
        ConfigurationService config = serviceRegistry.getService(ConfigurationService.class);
        String setting = config.getSetting(AvailableSettings.HBM2DDL_AUTO, String.class, null);
        return (setting != null || ENABLED_ON.contains(setting));
    }

    private void addEnumsAsTableConstantsAndFkConstraint(InFlightMetadataCollector metadataCollector) {
        for (PersistentClass persistentClass : metadataCollector.getEntityBindings()) {
            Class<?> plainJavaClass = persistentClass.getMappedClass();
            if (Enum.class.isAssignableFrom((plainJavaClass))) {
                createEnumInsertsAndDbColumns(persistentClass, plainJavaClass, metadataCollector);
            }
            tryAddFkConstraint(persistentClass, metadataCollector);
        }
    }

    private void tryAddFkConstraint(PersistentClass persistentClass, InFlightMetadataCollector metadataCollector) {
        Consumer<Field> createEnumFkConstraintForField = field -> {
            String fieldName = field.getName();
            PersistentClass targetPersistentClass = metadataCollector.getEntityBinding(field.getType().getCanonicalName());
            if (targetPersistentClass == null) {
                LOG.error("Target (enum) class must be an @Entity: {}", field.getType().getCanonicalName());
                System.exit(1);
            }
            Property enumReferenceAnnotatedProperty = persistentClass.getProperty(fieldName);
            persistentClass.getTable().createForeignKey(null,
                    Arrays.asList(enumReferenceAnnotatedProperty.getColumnIterator().next()),
                    targetPersistentClass.getEntityName());
        };

        Field[] declaredFields = persistentClass.getMappedClass().getDeclaredFields();
        of(declaredFields).filter(field -> field.isAnnotationPresent(EnumReference.class)).forEach(
                createEnumFkConstraintForField);
    }

    private void createEnumInsertsAndDbColumns(PersistentClass persistentClass, Class<?> clazz,
            InFlightMetadataCollector metadata) {
        String tableName = persistentClass.getTable().getName();
        Enum<?>[] enumJavaConstants = clazz.asSubclass(Enum.class).getEnumConstants();

        ArrayList<String> insertCommandAccumulator = new ArrayList<String>(enumJavaConstants.length);

        Optional<Field> enumValueAnnotatedField = of(enumJavaConstants.getClass().getComponentType().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(EnumValue.class)).map(fieldWithEnumValue -> {
                    fieldWithEnumValue.setAccessible(true);
                    return fieldWithEnumValue;
                }).findAny(); // just none or one is supported

        if (enumValueAnnotatedField.isPresent()) {
            setMinimalFieldLengthOfExitingColumn(enumValueAnnotatedField.get(), enumJavaConstants, persistentClass);
        }

        for (int i = 0; i < enumJavaConstants.length; i++) {
            Enum<?> it = enumJavaConstants[i];
            String constantEnumValue = enumValueAnnotatedField.map(v -> getInstanceValueOfEnumValueAnnotation(it, v))
                    .orElse(it.name());
            if (!enumValueAnnotatedField.isPresent()) {
                insertAdditionalColumn(persistentClass, metadata.getDatabase(), enumJavaConstants);
            }
            insertCommandAccumulator.add(createInsert(tableName, i, constantEnumValue));
        }

        InitCommand initCommand = new InitCommand(insertCommandAccumulator.toArray(new String[0]));
        persistentClass.getTable().addInitCommand(initCommand);
    }

    private void setMinimalFieldLengthOfExitingColumn(Field field, Enum<?>[] enumJavaConstants,
            PersistentClass persistentClass) {
        Property property = persistentClass.getProperty(field.getName());
        Column column = persistentClass.getTable().getColumn(Identifier.toIdentifier(property.getName()));
        Integer maxLengthOfEnums = maxLengthOfEnums(enumJavaConstants,
                e -> getInstanceValueOfEnumValueAnnotation(e, field));
        column.setLength(maxLengthOfEnums);
    }

    private String getInstanceValueOfEnumValueAnnotation(Enum<?> myEnum, Field enumValueAnnotatedField) {
        try {
            return enumValueAnnotatedField.get(myEnum).toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    private static Integer maxLengthOfEnums(Enum<?>[] enums, Function<Enum<?>, String> enumConstantValueExtractor) {
        return of(enums).map(it -> enumConstantValueExtractor.apply(it).length()).reduce(Math::max)
                .orElse(DEFAULT_VARCHAR_SIZE);
    };

    private void insertAdditionalColumn(PersistentClass persistentClass, Database database, Enum<?>[] enumJavaConstants) {
        Integer maxEnumStringLength = maxLengthOfEnums(enumJavaConstants, c -> c.name());
        Column column = new Column(DEFAULT_COLUMN_NAME.render(database.getDialect()));
        String typeName = database.getDialect().getTypeName(Types.VARCHAR, maxEnumStringLength, 0, 0);
        column.setSqlType(typeName);
        persistentClass.getTable().addColumn(column);
    }

    private String createInsert(String tableName, int position, String dbEnumValue) {
        return ("insert into " + tableName + " values(" + position + ",\'" + dbEnumValue + "\')");
    }
}
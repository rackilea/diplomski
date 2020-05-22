public class CascadingMongoEventListener extends AbstractMongoEventListener {

private static final Logger logger = LoggerFactory.getLogger(CascadingMongoEventListener.class);
@Autowired
private MongoOperations mongoOperations;

@Override
public void onBeforeConvert(final Object source) {
    ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {

        public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            ReflectionUtils.makeAccessible(field);

            if (field != null) {
                Object fieldValue = field.get(source);
                if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
                    if (Collection.class.isAssignableFrom(fieldValue.getClass())) {
                        Collection<Object> collection = (Collection<Object>) fieldValue;
                        for (Object item : collection) {
                            if (mongoOperations.collectionExists(item.getClass())) {
                                mongoOperations.save(item);
                                logger.debug("Set of {}s saved.", item.getClass().getSimpleName());
                            }
                        }
                    } else {
                        if (mongoOperations.collectionExists(fieldValue.getClass())) {
                            mongoOperations.save(fieldValue);
                            logger.debug("{} saved.", fieldValue.getClass().getSimpleName());
                        }
                    }
                }
            }
        }
    });
  }
}
@Override
public void configureTypeRegistry(TypeRegistry typeRegistry) {
    typeRegistry.defineDataTableType(
            new DataTableType(
                    Boolean.class,
                    Boolean::parseBoolean
            ));
}
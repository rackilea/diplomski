class DataFactoryBuilder {

    private DataFactoryBuilder() {
    }

    public static IDataFactory<? extends IDataObject> getFactory(Class<? extends IDataObject> clazz){    

        if (IDataSample1.class.isAssignableFrom(clazz)) {
            return new DataSample1Fac();
        }
        return null;
    }
}
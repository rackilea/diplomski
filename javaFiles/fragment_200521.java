Map<Class<? extends IType>, Factory<? extends IType>> factoryList =
        new HashMap<Class<? extends IType>, Factory<? extends IType>>();

private <T extends IType> IMode convert(T iType) {
    //unchecked cast - implementation must guarantee map holds correct data
    Factory<T> factory = (Factory<T>)factoryList.get(iType.getClass());
    //then convert
    return factory.get(iType);
}
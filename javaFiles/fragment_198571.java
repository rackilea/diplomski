public AnotherType toAnotherType(Type type) {

    AnotherType anotherType = new AnotherType();
    anotherType.setName(type.getName());

    if (type.getTypes() != null && !type.getTypes().isEmpty()) {

        List<AnotherType> lAnotherTypes = new ArrayList<>();

        for(Type innerType : type.getTypes()) {
            AnotherType innerAnotherType = toAnotherType(innerType);
            lAnotherTypes.add(innerAnotherType);
        }
        anotherType.setTypes(lAnotherTypes);
    }   

    return anotherType;
}
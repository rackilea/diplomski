PodamFactory podamFactory = new PodamFactoryImpl();
TypeManufacturer<Integer> manufacturer = new IntTypeManufacturerImpl() {

    @Override
    public Integer getInteger(AttributeMetadata attributeMetadata) {

        if (attributeMetadata.getPojoClass() instanceof Timestamp) {
            return PodamUtils.getIntegerInRange(0, 999999999);
        } else {
            return super.getInteger(attributeMetadata);
        }
    }
};
podamFactory.getStrategy().addOrReplaceTypeManufacturer(int.class, manufacturer);

FieldData pojo = podamFactory.manufacturePojo(FieldData.class);
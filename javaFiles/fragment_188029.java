public boolean isSerializablePropertyField(final ConversionService conversionService) {
    if (isRelationship()) return false;
    final Class<?> type = getType();
    if (getTypeInformation().isCollectionLike()) {
        return isConvertible(conversionService, getComponentType());
    }
    return isConvertible(conversionService, type);
}

private boolean isConvertible(ConversionService conversionService, Class<?> type) {
    return conversionService.canConvert(type, propertyType) && conversionService.canConvert(propertyType, type);
}
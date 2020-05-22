public MyConversionService implements IStandardConversionService {
    GenericConversionService myConverter = new MyConverter();
    StandardConversionService standardConversionService = new StandardConversionService();

    @Override
    public <T> T convert(Configuration configuration, IProcessingContext processingContext, Object object, Class<T> targetClass) {

        if (myConverter.canConvert(object.getClass(), targetClass)) {
            return myConverter.convert(object, targetClass);
        }

        return standardConversionService.convert(configuration, processingContext, object, targetClass);
    }
}
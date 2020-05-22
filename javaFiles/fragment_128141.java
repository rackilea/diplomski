protected <T> void writeWithMessageConverters(T returnValue, MethodParameter returnType,
            ServletServerHttpRequest inputMessage, ServletServerHttpResponse outputMessage)
            throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
    ...
    ((GenericHttpMessageConverter<T>) messageConverter).write(returnValue, returnValueType, selectedMediaType, outputMessage);
    ...
}
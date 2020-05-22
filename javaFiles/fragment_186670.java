public static <T extends RuntimeException> void logErrorAndThrowException(Logger logger,     
    String errorMessage, Class<T> exceptionClazz) throws T
{
    logger.error(errorMessage);
    // Note: no checks for null here. If null, just throw a "plain" RuntimeException
    throw MAP.get(exceptionClazz).doException(errorMessage);
}
public static List<String> getExceptionMessageChain(Throwable throwable) {
    List<String> result = new ArrayList<String>();
    while (throwable != null) {
        result.add(throwable.getMessage());
        throwable = throwable.getCause();
    }
    return result; //["THIRD EXCEPTION", "SECOND EXCEPTION", "FIRST EXCEPTION"]
}
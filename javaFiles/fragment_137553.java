try {
    //...
    MDC.put("key1", value1);
    MDC.put("key2", value2);
    //...
} finally {
    //this
    MDC.remove("key1");
    MDC.remove("key2");
    //or this
    MDC.clear();
}
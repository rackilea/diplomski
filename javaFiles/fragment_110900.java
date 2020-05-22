private static String getThreadsLockFile() {
    Set<Thread> threads = Thread.getAllStackTraces().keySet();
    StringBuilder builder = new StringBuilder();
    for (Thread thread : threads) {
        builder.append(getThreadsLockFile(thread));
    }
    return builder.toString();
}

private static String getThreadsLockFile(Thread thread) {
    StringBuffer stringBuffer = new StringBuffer();
    try {
        Field field = thread.getClass().getDeclaredField("threadLocals");
        field.setAccessible(true);
        Object map = field.get(thread);
        Field table = Class.forName("java.lang.ThreadLocal$ThreadLocalMap").getDeclaredField("table");
        table.setAccessible(true);
        Object tbl = table.get(map);
        int length = Array.getLength(tbl);
        for (int i = 0; i < length; i++) {
            try {
                Object entry = Array.get(tbl, i);
                if (entry != null) {
                    Field valueField = Class.forName("java.lang.ThreadLocal$ThreadLocalMap$Entry").getDeclaredField("value");
                    valueField.setAccessible(true);
                    Object value = valueField.get(entry);
                    if (value != null) {
                        stringBuffer.append(thread.getName()).append(" : ").append(value.getClass()).
                                append(" ").append(value).append("\n");
                       }
                }
            } catch (Exception exp) {
                // skip, do nothing
            }
        }
    } catch (Exception exp) {
        // skip, do nothing
    }
    return stringBuffer.toString();
}
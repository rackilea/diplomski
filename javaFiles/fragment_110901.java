private static String getThreadsLockFile(String fileName) {
    Set<Thread> threads = Thread.getAllStackTraces().keySet();
    StringBuilder builder = new StringBuilder();
    for (Thread thread : threads) {
        builder.append(getThreadsLockFile(thread, fileName));
    }
    return builder.toString();
}

private static String getThreadsLockFile(Thread thread, String fileName) {
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
                        int length1 = Array.getLength(value);
                        for (int j = 0; j < length1; j++) {
                            try {
                                Object entry1 = Array.get(value, j);
                                Field ownerField = Class.forName("sun.nio.fs.NativeBuffer").getDeclaredField("owner");
                                ownerField.setAccessible(true);
                                String owner = ownerField.get(entry1).toString();
                                if (owner.contains(fileName)) {
                                    stringBuffer.append(thread.getName());
                                }
                            } catch (Exception exp) {
                                // skip, do nothing
                            }
                        }
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
56    private static StringWriter sw = new StringWriter();
57    private static PrintWriter pw = new PrintWriter(sw);

112    synchronized(sw) {
113        t.printStackTrace(pw);
114        s = sw.toString();
115        sw.getBuffer().setLength(0);
116    }
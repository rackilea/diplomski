public class XXX {
    private final static Map<String, SimpleDateFormatThreadLocal> formatMap = 
        new HashMap<String, SimpleDateFormatThreadLocal>();

    static {
        String[] patterns = {"a", "b", "c"};
        for(String pattern: patterns){
            formatMap.put(pattern, new SimpleDateFormatThreadLocal(pattern));
        }
    }

    private static class SimpleDateFormatThreadLocal extends ThreadLocal<SimpleDateFormat> {
        private final String pattern;

        public SimpleDateFormatThreadLocal(String pattern) {
            this.pattern = pattern;
        }
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(pattern);
        }
    }
}
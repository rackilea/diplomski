package somepackage;
    public class Config {
        public Config() throws Exception {
            String pattern = System.getProperty("mylogfile", "javalog.log");
            FileHandler f = new FileHandler(pattern);
            Logger.getLogger("").addHandler(f);
        }
    }
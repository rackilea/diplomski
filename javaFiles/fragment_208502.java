public class Config {
    public static class Advertising {
        public boolean enabled;
    }
    public static class Control {
        public Advertising advertising;
    }
    public static class Logging {
        public boolean chat;
        public boolean commands;
        public String format;
    }

    Control control;
    Logging logging;
}
public static class Image {
        public enum Display {
            COVER, CONTAIN, START, END
        }
        public enum Type {
            BASE64, FILE, URL
        }
        public final Type type; // <-- this!
        public final Display display;
        public final int padding;
        public final String content;

        public Image(Type type, Display display, int padding, String content) {
            this.type = type;
            this.display = display;
            this.padding = padding;
            this.content = content;
        }
    }
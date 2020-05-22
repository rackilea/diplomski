@ConfigurationProperties
public class DemoApplication {

    ...

    public static class UrlProperties {
        // use Path or File so it's type-safe
        private Path path;

        // use int for type-safety 
        private int timeout;

        public Path getPath() {
            return path;
        }

        public void setPath(final Path path) {
            this.path = path;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(final int timeout) {
            this.timeout = timeout;
        }

        @Override
        public String toString() {
            return "UrlProperties{" + "path=" + path + ", timeout=" + timeout + '}';
        }
    }
}
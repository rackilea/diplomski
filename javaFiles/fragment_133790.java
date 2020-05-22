@Configuration
    public class PageConfig {

        @Value("${pageable.default}")
        private int pageDefault;

        public int getPageDefault() {
            return pageDefault;
        }

    }
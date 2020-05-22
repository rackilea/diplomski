public class MyApplication extends WebApplication {

        @Override
        protected void init() {
            super.init();
            ...
            mountPage("index.html", IndexPage.class);
            ...
        }

        @Override
        public Class<? extends Page> getHomePage() {
           return HomePage.class;
        }

        public static class HomePage extends IndexPage{}

    }
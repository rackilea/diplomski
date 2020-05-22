Request request = Request.classes(...
    Filter filter = new Filter() {
        @Override
        public boolean shouldRun(Description description) {
            ... get class and method and decide...

        }
        @Override
        public String describe() {
            return null;
        }
    };
    request.filterWith(filter);
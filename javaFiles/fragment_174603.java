class Providers {
    public static final ResultProvider<String> HTTP_GETTER = new ResultProvider<String>() {

        @Override
        public String generateResultInBackground(String... params) {
            return MagicHttpLibrary.getContentAsString(params[0]);
        }

    };
}
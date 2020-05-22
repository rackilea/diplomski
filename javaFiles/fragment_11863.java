public class Woman extends Human {

    protected String loveMovie;

    public static class WomanBuilder extends HumanBuilder<Woman, WomanBuilder> {

        protected String loveMovie;

        public WomanBuilder loveMovie(String loveMovie) {
            this.loveMovie = loveMovie;
            return this;
        }

        @Override
        protected void fill(Woman woman) {
            super.fill(woman);
            woman.loveMovie = this.loveMovie;
        }

        @Override
        protected Woman create() {
            return new Woman();
        }
    }
}
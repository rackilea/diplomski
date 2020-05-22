public class Main {

    public static class Good implements Interfaze<Good> {

        @Override
        public Good convert() { return new Good(); } // Compiles
    }

    public static class Bad implements Interfaze<Bad> {

        @Override
        public Bad convert() { return new Good(); } // Doesn't compile
    }
}
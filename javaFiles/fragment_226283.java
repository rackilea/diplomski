public enum Color {
    //...
    RANDOM(0) {
        @Override
        public int getRGB() {
            return Utils.randomColor();
        }
    };

    //...
}
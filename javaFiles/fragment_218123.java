public enum Direction {
    UP {
        public int getWidth() {
            return 50;
        }
        @Override
        public int getHeight() {
            return 100;
        }
    },
    DOWN {
        public int getWidth() {
            return 30;
        }
    };

    public abstract int getWidth();
    public int getHeight() {
        return 10;
    }
}
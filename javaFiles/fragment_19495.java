enum RoundingMode {
    UP {
        public double round(double d) {
            return Math.ceil(d);
        }
    },
    DOWN {
        public double round(double d) {
            return Math.floor(d);
        }
    };

    public abstract double round(double d);
}
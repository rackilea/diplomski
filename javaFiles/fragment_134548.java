public abstract class Real {
    public abstract Real plus(double value);

    public static Real infinity() {
        return new Infinity();
    }

    public static Real regular(double value) {
        return new RegularReal(value);
    }

    private static class Infinity extends Real {
        @Override
        public void plus(double value) {
            return this;
        }
    }

    private static class RegularReal extends Real {
        private final double value;

        private RegularReal(double value) {
            this.value = value;
        }

        @Override 
        public Real plus(double value) {
            return new RegularReal(this.value + value);
        }
    }
}
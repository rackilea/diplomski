public enum VehicleType {
    Car {
        @Override
        public ObjectProcessor createImpl() {
            return new ObjectProcessor() {

                @Override
                public void process(List<String> objectNames) {
                    // car logic
                }

            };
        }
    },
    Van {
        @Override
        public ObjectProcessor createImpl() {
            return new ObjectProcessor() {

                @Override
                public void process(List<String> objectNames) {
                    // van logic
                }

            };
        }
    };
    public abstract ObjectProcessor createImpl();
}
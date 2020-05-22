enum CommunicationStyle {
    DIRECT() {
        @Override
        public Clients clients(Object configLoader) {
            return new Clients(configLoader.getProperty("someprop"));
        }
    },
    SERVICE() {
        @Override
        public Clients clients(Object configLoader) {
            return new Clients(configLoader.getProperty("otherprop"));
        }
    };

    public abstract Clients clients();
}
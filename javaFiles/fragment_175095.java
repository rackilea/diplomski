class SalesRepById {
    SalesRepById(...) {
        ...
    }

    @Override
    public Map<String, ObjectImplementation> parse() {
        try {
            Class<? extends ObjectImplementation> typeFromFile =
                Class.forName(...).asSubclass(ObjectImplementation.class);

            ObjectImplementation instance =
                typeFromFile.getConstructor().newInstance();

        ...
    }
}
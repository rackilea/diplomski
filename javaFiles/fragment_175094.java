class SalesRepById<D extends ...> {
    private Class<D> typeOfD;

    SalesRepById(..., Class<D> typeOfD) {
        ...
        this.typeOfD = typeOfD;
    }

    @Override
    public Map<String, D> parse() {
        try {
            Class<? extends D> typeFromFile =
                Class.forName(...).asSubclass(typeOfD);

            D instanceOfD =
                typeFromFile.getConstructor().newInstance();

        ...
    }
}
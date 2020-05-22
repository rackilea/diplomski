static final Map<String, Supplier<KnotStrategy>> KNOTS = (
    new HashMap<String, Supplier<KnotStrategy>>()
);
static {
    KNOTS.put("slip", SlipKnot::new);
    KNOTS.put("granny", GrannyKnot::new);
    KNOTS.put("bowline", BowlineKnot::new);
}

static KnotStrategy getKnotStrategy(String name) {
    Supplier<KnotStrategy> supp = KNOTS.get(name);
    if(supp != null) {
        return supp.get();
    }

    throw new IllegalArgumentException();
}
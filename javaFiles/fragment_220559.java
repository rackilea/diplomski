final class ResearchEffectTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory researchEffectTypeAdapterFactory = new ResearchEffectTypeAdapterFactory();

    // Encapsulate the way it's instantiated
    private ResearchEffectTypeAdapterFactory() {
    }

    // ... not letting the caller to instantiate it with `new` -- it's a stateless singleton anyway, so one instance per application is FULLY legit
    static TypeAdapterFactory getResearchEffectTypeAdapterFactory() {
        return researchEffectTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Classes can be compared by == and !=
        // Note that we handle IResearchEffect only, otherwise we know that Gson has enought information itself
        if ( typeToken.getRawType() != IResearchEffect.class ) {
            return null;
        }
        // Create the type adapter for the IResearchEffect and cast it
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> typeAdapter = (TypeAdapter<T>) new MyTypeAdapter(gson);
        return typeAdapter;
    }

    private static final class MyTypeAdapter
            extends TypeAdapter<IResearchEffect> {

        private final Gson gson;

        private MyTypeAdapter(final Gson gson) {
            this.gson = gson;
        }

        @Override
        public void write(final JsonWriter out, final IResearchEffect value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public IResearchEffect read(final JsonReader in) {
            // Since readers and writers are one-use only, you have to buffer the current value in an in-memory JSON tree
            final JsonElement jsonElement = gson.fromJson(in, JsonElement.class);
            // Extract the className property
            final String className = jsonElement.getAsJsonObject().get("className").getAsString();
            // And resolve the instantiation class
            // Note that I'm using switch here because I use another packages for this demo and I have to remap the original document strings to my demo mappings
            // You have to use something like gson.from(jsonElement, Class.forName(className));
            // Or whatever you prefer, but I would extract it as a strategy
            switch ( className ) {
            case "com.example.slarocque.cellclicker.Research.ResearchEffects.ClickAmountEffectStatic":
                return gson.fromJson(jsonElement, ClickAmountEffectStatic.class);
            case "com.example.slarocque.cellclicker.Research.ResearchEffects.ClickAmountEffectPercent":
                return gson.fromJson(jsonElement, ClickAmountEffectPercent.class);
            default:
                throw new IllegalArgumentException("Cannot instantiate " + className);
            }
        }

    }

}
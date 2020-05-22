CustomHttpMessageConverter extends GsonHttpMessageConverter {
    protected static final String DATE_FORMAT = "yyyy-MM-dd";

    protected static Gson buildGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setDateFormat(DATE_FORMAT);

        return gsonBuilder.create();
    }

    public CustomHttpMessageConverter()  {
        super(buildGson());
    }
}
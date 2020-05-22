final static F.Function<String, Boolean> filter = new F.Function<String, Boolean>() {
    @Override
    public Boolean apply(String key) {
        try {
            return key.startsWith("js.");
        } catch (Throwable throwable) {
            return false;
        }
    }
};
final static jsmessages.JsMessages messages = JsMessages.filtering( play.Play.application(),filter);
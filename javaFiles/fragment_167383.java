class DataWrapper {
    public Data data;

    public static DataWrapper fromJson(String s) {
        return new Gson().fromJson(s, DataWrapper.class);
    }
    public String toString() {
        return new Gson().toJson(this);
    }
}
class Data {
    public List<Translation> translations;
}
class Translation { 
    public String translatedText;
}
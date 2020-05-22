public static void main(String[] args) {
    Gson gson = new GsonBuilder().registerTypeAdapter(Time.class, new MyTimeJsonDeserializer()).create();
    MyTime time = gson.fromJson("{\"time\": \"19:31:00\"}", MyTime.class);
    System.out.println(time.getTime());
}

public static class MyTime{

    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

public static class MyTimeJsonDeserializer implements JsonDeserializer<Time>{

    @Override
    public Time deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String time = json.getAsString();
        String[] parts = time.split(":");
        return new Time(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
    }

}
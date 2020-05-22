class MyCustomTypeAdapter extends TypeAdapter<UserSimple> {
    @Override
    public void write(JsonWriter writer, UserSimple userSimple) throws IOException {
        writer.beginObject();
        if(userSimple.getName() != null){
            writer.name("name");
            writer.value(userSimple.getName());
        }

        // you want to include email even if it's null
        writer.name("email");
        writer.value(userSimple.getEmail());

        if(userSimple.getAge() != null){
            writer.name("age");
            writer.value(userSimple.getAge());
        }
        if(userSimple.getDeveloper() != null){
            writer.name("isDeveloper");
            writer.value(userSimple.getDeveloper());
        }
        writer.endObject();
    }

    public UserSimple read(JsonReader reader) throws IOException {
    // you could create your own
        return null;
    }
}
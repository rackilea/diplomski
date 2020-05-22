// let Program have empty constructor (or no constructors at all), getters and setters
class ProgramAdapter extends TypeAdapter<Program> {

    @Override
    public Program read(final JsonReader in) throws IOException {
        final Program obj = new Program();

        in.beginObject();
        while (in.hasNext()) {
            String jsonTag = in.nextName();
            if ("desc".equals(jsonTag)) {
                obj.setDescription(in.nextString());
            } else if ("title".equals(jsonTag) 
                    || "name".equals(jsonTag)) {
                obj.setTitle(in.nextString());
            }
        }
        in.endObject();

        return obj;
    }

    @Override
    public void write(final JsonWriter out, final Program obj)
            throws IOException {
        out.beginObject();
        out.name("title").value(obj.getTitle());
        out.name("desc").value(obj.getDescription());
        out.endObject();
    }
}

// then, when create `Gson` object:

Gson gson = new GsonBuilder().registerTypeAdapter(Program.class, new ProgramAdapter()).create();
public class PersonTypeAdapter extends TypeAdapter<Person> {
  @Override
  public void write(JsonWriter out, Person value) throws IOException {
    if (value == null) {
      out.nullValue();
      return;
    }

    out.beginObject();
    out.name("name").value(value.name);
    out.name("sirname").value(value.sirname);
    out.name("details");
    out.beginObject();
    out.name("social_no").value(value.social_no);
    out.name("creadit_card_no").value(value.creadit_card_no);
    out.endObject();
    out.endObject();
  }

  @Override
  public Person read(JsonReader reader) throws IOException {
    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull();
      return null;
    }

    reader.beginObject();
    validateName(reader, "name");
    String name = reader.nextString();
    validateName(reader, "sirname");
    String sirname = reader.nextString();
    validateName(reader, "details");
    reader.beginObject();
    validateName(reader, "social_no");
    String social_no = reader.nextString();
    validateName(reader, "creadit_card_no");
    String creadit_card_no = reader.nextString();
    reader.endObject();
    reader.endObject();
    return new Person(name, sirname, social_no, creadit_card_no);
  }

  private void validateName(JsonReader reader, String string) throws IOException {
    String name = reader.nextName();
    if(!string.equals(name)) {
      throw new JsonSyntaxException("Expected: \"" + string + "\", got \"" + name + "\"");
    }
  }
}
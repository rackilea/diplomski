public class LocalDateAdapter extends TypeAdapter<LocalDate> {
     public LocalDate read(JsonReader reader) throws IOException {
       if (reader.peek() == JsonToken.NULL) {
         reader.nextNull();
         return null;
       }
       String xy = reader.nextString();
       return new LocalDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(xy);
     }
     public void write(JsonWriter writer, LocalDate value) throws IOException {
       if (value == null) {
         writer.nullValue();
         return;
       }
       String xy = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(value.getTime());
       writer.value(xy);
     }
   }
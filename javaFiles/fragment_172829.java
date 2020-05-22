public class Helper_StringAdapter extends TypeAdapter<String>{
@Override
public String read(com.google.gson.stream.JsonReader in) throws IOException {
   if(in.peek() == JsonToken.NULL){
       in.nextNull();
       return null;
   }else if(in.peek() == JsonToken.BEGIN_OBJECT && in.getPath().contains(".video")){
       L.e("VIDEO IS AN OBJECT!");
       String userId = readAndReturnVideoId(in);
       return userId;
   }else{
       return in.nextString();
   }
}

private String readAndReturnVideoId(com.google.gson.stream.JsonReader reader) throws IOException{
    String id = "";
    reader.beginObject();
    while(reader.hasNext()){
        String name = reader.nextName();
        if(name.equals("_id")){
            id = reader.nextString();
        }else{
            reader.skipValue();
        }
    }
    reader.endObject();
    L.e("READ ID RETURNED"+id);
    return id;
}

@Override
public void write(com.google.gson.stream.JsonWriter out, String value) throws IOException {
    L.e("TEST "+out);
}
}
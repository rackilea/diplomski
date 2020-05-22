if(reader.peek() != JsonToken.NULL) {
   teamName = reader.nextString();
 }
 else {
   teamName = null;
 }
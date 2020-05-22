if (currentToken == JsonToken.VALUE_STRING) {
   if (_stringDeserializer != null) {
      return _stringDeserializer.deserialize(jp, ctxt)
   }
   String text = jp.getText();
   if (dateTimeFormatRegex.match(text) {
      return toDateTimeObject(text);
   } else {
      return text;
   }
}
return super.deserialize(jp, ctxt)

public DateTime toDateTimeObject(String text) {
     dateTimeFormatter.parseDateTime(text)
}
public <T> T get (T defaultValue) {
  if (attributes.containsKey (defaultValue.getClass ())) {
     return (T) attributes.get (defaultValue.getClass ());
   } else  {
     return defaultValue;
   }
}
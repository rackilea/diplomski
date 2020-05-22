static Cflb getEnumnByInternalName(String iname) {
  for(Cbfl c : values()){
    if(c.name.equals(iname)){
      return c;
    }
  }
  return null; //or throw an Exception, whatever you need
}
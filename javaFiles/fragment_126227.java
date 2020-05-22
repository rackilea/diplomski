public void setName(String name) throws IllegalArgumentException {
   if ("".equals(name) || name == null) {
    throw new IllegalArgumentException("Name should not be null or empty");
   }
   this.name=name;

 }
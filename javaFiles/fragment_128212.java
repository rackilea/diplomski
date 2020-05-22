class Dynamic { 
  private final Map<String,Object> members = new HashMap<>();

  public void setMember(String name, Object value) {
      members.put(name,value);
  }

  public Object getMember(String name) {
     return members.get(name);
  } 

}
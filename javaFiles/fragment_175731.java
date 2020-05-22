class UserMap{
  Map<String,List<User> userMapOfSchool;

  @Override
  public String toString(){
   return
   userMapOfSchool.entrySet()
                  .stream()
                  .map(e -> e.getKey() + " has " + e.getValue().size() + " students")
                  .collect(joining("\n"));
  }
}
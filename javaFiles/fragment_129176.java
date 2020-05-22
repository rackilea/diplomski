class Entity {
  int id;
  public static Entity generate(){
      Entity e = new Entity ();
      int rand = MathUtil.generateRandomInt(); // method in util class 
                 in the project.
      e.setId(rand )
      return e;
 }
}
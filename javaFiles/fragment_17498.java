@TypeName("Entity")
class Entity {
    @Id Point id
    String data
}

class Point {
    double x
    double y

    String myToString() {
        "("+ (int)x +"," +(int)y + ")"
    }
}

def "should use custom toString function for complex Id"(){
  given:
  Entity entity = new Entity(id: new Point(x: 1/3, y: 4/3))

  when: "default reflectiveToString function"
  def javers = JaversBuilder.javers()
          .build()
  GlobalId id = javers.getTypeMapping(Entity).createIdFromInstance(entity)

  then:
  id.value() == "Entity/0.3333333333,1.3333333333"

  when: "custom toString function"
  javers = JaversBuilder.javers()
          .registerValueWithCustomToString(Point, {it.myToString()})
          .build()
  id = javers.getTypeMapping(Entity).createIdFromInstance(entity)

  then:
  id.value() == "Entity/(0,1)"
}
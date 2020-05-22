class Baby {
  String name
  String toString(){"Baby: ${name}"}
}
class Person {
  String name
  def plus(Person o) {
    return new Baby(name: "${this.name} - ${o.name}")
  }
​}

def person1 = new Person(name: "Person 1")
def person2 = new Person(name: "Person 2")
assert "Baby: Person 1 - Person 2" == (person1 + person2)
​
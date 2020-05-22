@Entity
class Parent {
  @OneToOne
  Intermediate intermediate;
}

@Entity
class Intermediate {
  @OneToOne(mappedBy="intermediate")
  Parent parent;
  @OneToOne
  Set<Child> children
}

@Entity
class Child {
  String someProperty;
}
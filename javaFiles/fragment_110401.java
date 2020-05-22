@Entity
class Person {
  @Id
  int id;

  @OneToOne
  Address address;
}

@Entity
class Address{
   @Id
   int id;

   String town;
}
@Entity
class Person {
    @Id UUID id;
    String firstname, lastname;
    @OneToOne
    Address address;
}

@Entity
static class Address {
    @Id UUID id;
    String zipCode, city, street;
}

interface NamesOnly {
    String getFirstname();
    String getLastname();
}

@Repository
interface PersonRepository extends Repository<Person, UUID> {
    Collection<NamesOnly> findByLastname(String lastname);
}
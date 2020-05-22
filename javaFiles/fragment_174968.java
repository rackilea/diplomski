public class Person {
    @OneToMany(mappedBy = "person")
    private Set<RankedAddress> rankedAddresses;
}

public class RankedAddress {
    @ManyToOne
    private Person person;

    @ManyToOne
    private Address address;
}

public class Address {
    @OneToMany(mappedBy = "adress")
    private Set<RankedAddress> rankedAddresses;
}
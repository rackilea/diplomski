public class Address {

        @Id
        @GeneratedValue
        private Long id;
        private String address;
        @OneToOne
        @PrimaryKeyJoinColumn
        private Company company;

        //getters and setters
    }

public class Company {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(mappedBy = "company",cascade = CascadeType.ALL)
    private Address companyAddress;

    //getters and setters
}
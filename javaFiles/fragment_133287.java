@Entity
public class Client implements Serializable {     
    @Id
    @GeneratedValue
    private Long clientId;     

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Address address; 

    ...
}

@Entity 
public class Address implements Serializable {
    @Id
    private Long fkClientId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "fk_clientid")
    private Client client; 

    ...
}
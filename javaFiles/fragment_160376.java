@Entity 
@XmlRootElement 
public class Contact { 

    @Id 
    private Long contactId; 

    @OneToMany(mappedBy = "contact") 
    private List<ContactAddress> addresses; 

... 

} 

@Entity 
@XmlRootElement 
public class ContactAddress { 

    @Id 
    private Long contactAddressId; 

    @ManyToOne 
    @JoinColumn(name = "contact_id") 
    @XmlInverseReference(mappedBy="addresses")
    private Contact contact; 

    private String address; 

... 

}
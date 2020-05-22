public class Client{

   @Id
   @Column(columnDefinition = "CHAR(11)")
   private String cpf;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(name="client_address", joinColumns = {
     @JoinColumn(name = "client_cpf") },
     inverseJoinColumns = { @JoinColumn(name = "address_zipcode", 
       referencedColumnName="zipCode"), @JoinColumn(name = "address_number", 
         referencedColumnName="number", @JoinColumn(name = 
         "address_complement", 
         referencedColumnName="complement"},
     uniqueConstraints = @UniqueConstraint(columnNames = {
       "client_cpf", "address_zipcode", "address_number",  
       "address_complement" })
   private List<Address> addresses;
   //get set
}
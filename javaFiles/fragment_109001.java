@Entity
@Table(name="user")  
public class User {

  @ID
  public Long id;

  @Column(name="userCode")
  public String userCode;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  public List<Address> addressList;

  ....
}

@Entity
@Table(name="address")  
public class Address {

  @Id
  @Column(name = "id")
  public Long id;

  @Column(name="userId")
  public Long userId;

  @Column(name="address-line-1")
  public String addressLine1;

  @Column(name="address-line-2")
  public String addressLine2;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "address_id")
  protected List<Phone> phoneList;

  ....
}

@Entity
@Table(name="phone")
public class Phone {

  @Id
  @Column(name = "id")
  public Long id;

  @Column(name="contact_no")
  public String contactNo;

  @Column(name="country_code")
  public int countryCode;

  @Column(name="address_id")
  public int addressId;

  ....
}
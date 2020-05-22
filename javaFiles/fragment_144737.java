@Component("addressBean")
@Scope("request")
public class AddressBean {

  @Autowired
  private AddressDAO dao;

  public String addAddress()
  {
      dao.saveAddress(address);
      return "";
  }

}
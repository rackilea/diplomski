public class UserServiceClass {

  @Autowired
  private UserElasticsearchRepository userElasticsearchRepository;

  public void updateAddress(int id, String updatedAddress) {
    User user = userElasticsearchRepository.findOne(id);
    if (user.getUsername().equals("system")) {
      return;
    }
    userElasticsearchRepository.updateAddress(user,updatedAddress);
  } 
}
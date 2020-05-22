public class UserBL {

@Autowired
UserDAO userDao;

@Transactional
public void saveUsers(){
    User user = new User();
    user.setName("Bob");

    userDao.insert(user);
}
}
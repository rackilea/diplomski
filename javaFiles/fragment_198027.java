@Service
public class UserService {

   @Autowired
   UserDao userDao;

   @Autowired
   OfficeContext office;

   public void persist(JUser user) {
       userDao.persist(user);
   }

   public void save(JUser user) {
       userDao.save(user);
   }


}
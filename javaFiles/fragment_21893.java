@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void updateUserName(String userId, String userName) {

        if(userId !=null && userName != null) {
                int result = this.userDAO.updateUser(userId, userName);

           if(result==0) //userid not available {
                //if userid is NOT available, what to do? check your requirement and handle properly
           }

           } 
       } else {
            //throw exception
       }
    }
    implementation of other methods...
}
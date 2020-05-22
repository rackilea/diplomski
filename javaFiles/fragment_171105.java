@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {

    ...

    //Do not role back this transaction
    @Transactional(propagation=Propagation.SUPPORTS, readOnly=false)
    @Override
    public void saveUser(User user) {
       userDAO.saveUser(user);
    }
}
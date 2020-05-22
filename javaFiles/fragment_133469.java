public class UserService {
    @Autowired UserDAO dao;

    @Transactional(readOnly = true) 
    public User getUserById(int id) {
        return dao.getById(id); // getById() can participate in effectively read-only transaction
    }

    @Transactional
    public void changeUserName(int id, String newName) {
        User u = dao.getById(id); // Or not
        u.setName(newName); // Change will be flushed at the end of transaction
    }
}
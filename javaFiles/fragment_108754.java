@Component
public class GroupConverter implements Converter<String, Group> {
    @Autowired
    GroupService groupService;
    public User convert(String element) {
        User user = null;
        if(element != null) {
            int id = Integer.parseInt(element);
            user = userService.fetchUser(id);
        }
        return user;
    }
}
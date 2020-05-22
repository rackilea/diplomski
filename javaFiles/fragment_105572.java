@Entity
public class TodolistUser {
@Id
@GeneratedValue
private Integer id;

private String login;
private String password;

@Autowired  // Not Recommended
@ElementCollection
private List<Task> tasks = new ArrayList<Task>(); // Or other implementations
}


@Service
public class TodolistUserService {
    @Autowired
    private TodolistUserRepository repository;

    public void addFoo(TodoListUser foo){
repository.save(foo);
}



}
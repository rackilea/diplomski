@Component
@Transactional
public class TodoDao implements ITodoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Override
    @PreAuthorize("@authenticationFacade.(#toDo)") // I want to access to one of my autowired bean here
    public void changeTodoStatus(Todo todo) {
        Object user = authenticationFacade.getAuthentication().getPrincipal();
        todo.setDone(!todo.isDone());
        sessionFactory.getCurrentSession().update(todo);
    }
}
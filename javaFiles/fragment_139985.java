/* takes any CrudRepository */
public abstract class CrudController<M extends Model, 
  R extends CrudRepository<M, Long>, S extends Service<M,R>> { ..

/* you'll have to be explicit in UserController with this signature */
public class UserController extends CrudController<User, UserRepository, UserService>{
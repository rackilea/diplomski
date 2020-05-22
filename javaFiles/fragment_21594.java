@Repository
public abstract class EntityRepository<T>{
    protected Class<T> entityClass;

    public EntityRepository(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    //...
}


public class UserEntityRepository extends EntityRepository<User>{
    public UserEntityRepository(){
        super(User.class);
    }
}
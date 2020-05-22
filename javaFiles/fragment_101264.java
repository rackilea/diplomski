@Service(value="inboxQueryBuilder")
public class InboxQueryBuilder {

@PersistenceContext
EntityManager em;

CriteriaBuilder cb;

public InboxQueryBuilder() {
    // em= null
}

@PostConstruct
public void toSomething(){
    // em set by Container  
    cb = em.getCriteriaBuilder();
}


public TypedQuery<App> getQueryForApps(AppSearchObject aso) {
       ...
}

...
}
public abstract class AbstractCrudDao<T> {
    private Collection<Listener> listeners = new HashSet<Listener>();

    public void addListener(final Listener listener) {
        listeners.add(listener);
    }

    protected void doAction(CrudAction<T> crudAction)
    {
        for(Listener listener : listeners) {
             listener.beforeAction();
        }
        crudAction.doAction();
        for(Listener listener : listeners) {
             listener.afterAction();
        }
    }

    public interface CrudAction {
        void doAction();
    }

    public interface Listener {
        void beforeAction();
        void afterAction();
    }
}

public class CarDao extends AbstractCrudDao {
    public void create(Car car) {
        doAction(new CrudAction() {
            public void doAction() {
                //create car here
            }
        });
    }
}
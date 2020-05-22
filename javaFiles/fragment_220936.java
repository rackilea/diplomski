@PersistenceCapable(detachable = "true")
 public class Parent implements Serializable { 
    ...
    @NotPersistent
    private Collection<Child> childList;
    ...      
 }
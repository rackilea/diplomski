@Entity
public class MyEntity{ 

    ....

    @PrePersist
    protected void checkDates() {
      // check dates
      // throw some runtime exception in a case of problems
    }
}
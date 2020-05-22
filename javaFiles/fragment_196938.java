@Entity
@Table(name = "activity)
@Inheritance
@DiscriminatorColumn(name = "activity_type")
public abstract class Activity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "activity_type")
    private int type;

    public abstract void execute();
}

@Entity
@DiscriminatorValue("1")
public class ActivityImplA extends Activity {

     public void execute() {
        .... Impl a
     }

}

@Entity
@DiscriminatorValue("2")
public class ActivityImplB extends Activity {

     public void execute() {
        .... Impl b
     }

}
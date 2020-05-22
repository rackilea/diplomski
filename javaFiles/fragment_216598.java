@Entity
@Table(name = "postit")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "foreign_table", discriminatorType = STRING)
public abstract class AbstractComment {
    // ... fields, getters, setters
}

@Entity
@DiscriminatorValue("t1")
public class T1Comment extends AbstractComment {

}

@Entity
@Table(name="t1")
public class T1 {
    @OneToMany
    @JoinColumn(name = "foreign_id")
    private Set<T1Comment> comments;
}
@Entity
@DiscriminatorColumn(name = "_type")
public abstract class AbstractSuperClass {

    @Column(name = "_type", insertable=false, updatable=false, nullable = false)
    private String type;    

}

@Entity
@DiscriminatorValue(SubClass.TYPE)
public class SomeSubClass extends AbstractSuperClass {

    public static final String TYPE = "SOME_SUBTYPE";
}
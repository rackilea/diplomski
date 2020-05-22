@TableGenerator(name="MyTableGen", table="SEQUENCES", pkColumnValue="MyClass")
@Entity
public class MyEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="MyTableGen")
    private long myId;

    ...
}
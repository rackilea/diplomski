@MappedSuperclass
public abstract class AbstractParentEntity {
    public String someField;
    ...
}

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public abstract class MyEntity extends AbstractParentEntity 
{
   //here you don't have any field (they all move to  AbstractParentEntity
   // (or, at least all the fields that need to be archivied are now declared in parent class)
   ....
}

@Entity
public class MyArchivedEntity extends AbstractParentEntity  
{
    private String archiveSpecificField;
    ....
@Entity
@Table(name="MODEL")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="entity_type",discriminatorType=DiscriminatorType.STRING)
public abstract class Model{

@Id
private int id;
//other common attributes
//getters& setters
}
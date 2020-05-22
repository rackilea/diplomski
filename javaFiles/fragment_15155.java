@Entity
@AttributeOverrides({@AttributeOverride(name="creationUser", column=@Column(name="PER_CREATION_USER", insertable=true, updatable=false)), 
                 @AttributeOverride(name="creationDate", column=@Column(name="PER_CREATION_DATE" insertable=true, updatable=false})
@Table(name="PERSON")
public class Person extends BaseDTO{
}
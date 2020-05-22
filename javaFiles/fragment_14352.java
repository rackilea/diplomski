@Entity
@Table(name = "square")
@DiscriminatorColumn(name = "squareType", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Square implements Indexable, Serializable{
  ...
}
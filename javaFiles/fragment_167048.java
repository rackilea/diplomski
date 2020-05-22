@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("...")
@DiscriminatorValue("not null")
public class Animal implements Serializable {
  ...
  @Column
  public String getName() { ... }
}
@Entity
@AssociationOverrides({
   @AssociationOverride(name = "list",
      joinColumns = @JoinColumn(referencedColumnName = "COLUMN_NEW_NAME"))
})
public class ConcreteEntity extends AbstractEntity {

}
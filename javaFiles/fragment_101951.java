@Entity
@Multitenant(MultitenantType.TABLE_PER_TENANT)
@Table(name = "account_master")
@SqlResultSetMapping(name = "DTO_MAPPING", classes = @ConstructorResult(
    targetClass = AccountDTO.class,
    columns = {@ColumnResult(name = "id"),
        @ColumnResult(name = "name"),
        @ColumnResult(name = "custom_properties", type=String.class)
    })
)
public class Account implements Serializable {
// fields, setters and getters

}
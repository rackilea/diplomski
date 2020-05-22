@Entity
@Table(name = "\"users\"")
@FilterDef(name = "activeUsers", parameters = @ParamDef(name = "active", type = "boolean"))
@Filter(name = "activeUsers", condition = "`active` = :active")
public class User {

    @Id
    private Long id;

    private boolean active;
    // getters/setters (not shown)
}
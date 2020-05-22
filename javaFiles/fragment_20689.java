@MappedSuperclass
@EntityListeners( { AuditingEntityListener.class})
@FilterDef(
    name = "tenancyFilter",
    parameters = {@ParamDef(
        name = "created",
        type = "timestamp"
    )}
)
public class Common
{

    private Timestamp created;

    public Timestamp getCreated()
    {
        return created;
    }

    public void setCreated( Timestamp created )
    {
        this.created = created;
    }
}
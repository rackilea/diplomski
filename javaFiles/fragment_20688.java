@Entity
@Filter(
    name = "tenancyFilter",
    condition = "et_created = :created"
)
@AttributeOverride(
    name = "created",
    column = @Column(
        name = "et_created"
    )
)
public class Test extends Common
{
    @Id
    @Column( name = "comp_id" )
    private UUID id;

    public UUID getId()
    {
        return id;
    }

    public void setId( UUID id )
    {
        this.id = id;
    }
}
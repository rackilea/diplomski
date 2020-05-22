@Entity
@Table( name = "TRADES" )
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "NOSTRO_FLAG", discriminatorType = DiscriminatorType.STRING, length = 1 )
public abstract class Trade implements Serializable
{
    @Column( name = "NOSTRO_FLAG", insertable = false, updatable = false )
    protected String discriminator;

    @Id
    @Column( name = "TRADE_ID" )
    protected Long id;

    ...

    protected Trade()
    {
    }

    public String getDiscriminator()
    {
        return this.discriminator;
    }

    public TradingSector getTradingSector()
    {
        return TradingSector.translate( this.discriminator );
    }

    ...
}
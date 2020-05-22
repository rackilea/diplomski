@Entity
@Table(name = "values")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Value<T extends Serializable> 
{
    @Id
    protected int id;

    protected String name;


    public abstract T getValue();

    public abstract void setValue(T value);
}

@Entity
@DiscriminatorValue("TEXT")
public class TextValue extends Value<String> 
{
    @Column(name = "text")
    private String value;

    @Override
    public String getValue() 
    {
        return value;
    }

    @Override
    public void setValue(String value) 
    {
        this.value = value;
    }
}

@Entity
@DiscriminatorValue("NUMERIC")
public class NumericValue extends Value<Double> 
{
    @Column(name = "numeric")
    private Double value;

    @Override
    public Double getValue() 
    {
        return value;
    }

    @Override
    public void setValue(Double value) 
    {
        this.value = value;
    }
}
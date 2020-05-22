@Entity
@NamedQuery(
    name="allPriceSteps",
    queryString="SELECT ps FROM PriceStep ps"
)
public class PriceStep implements Serializable {
...
}
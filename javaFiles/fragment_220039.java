@Entity
@Table(name = "supplyorderlines")
public class SupplyOrderLine implements IOrderLine, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(targetEntity = SupplyOrderLine.class)
    private List<SupplyOrderLine> customerOrderLines;

    @Override
    public List<IOrderLine> getOrderLines() {
        return customerOrderLines;
    }
}
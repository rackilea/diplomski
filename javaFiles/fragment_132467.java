@Entity
@Table(name="ADD_ON_ITEMS")
public class AddOnEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ADD_ON_ID")
    private Integer addOnId;

    @Column(name="ADD_ON_NAME")
    private String addOnName;

    @Column(name="ADD_ON_PRICE")
    private Double addOnPrice;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private ItemsEntity primaryItem;

    public Integer getAddOnId() {
        return addOnId;
    }

    public void setAddOnId(Integer addOnId) {
        this.addOnId = addOnId;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public Double getAddOnprice() {
        return addOnPrice;
    }

    public void setAddOnprice(Double addOnprice) {
        this.addOnPrice = addOnprice;
    }

    public ItemsEntity getPrimaryItem() {
        return primaryItem;
    }

    public void setPrimaryItem(ItemsEntity primaryItem) {
        this.primaryItem = primaryItem;
    }


}
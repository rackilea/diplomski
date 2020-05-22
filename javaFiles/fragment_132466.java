@Entity
@Table(name="ITEMS")
public class ItemsEntity {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name="ITEM_ID")
   private Integer itemId;

   @Column(name="ITEM_NAME")
   private String itemName;

   @Column(name="ITEM_PRICE")
   private Double itemPrice;


   @OneToMany(mappedBy="primaryItem",cascade=CascadeType.ALL)   
   private List<AddOnEntity> entity;

   public Integer getItemId() {
       return itemId;
   }

   public void setItemId(Integer itemId) {
       this.itemId = itemId;
   }

   public String getItemName() {
       return itemName;
   }

   public void setItemName(String itemName) {
       this.itemName = itemName;
   }

   public Double getPrice() {
       return itemPrice;
   }

   public void setPrice(Double price) {
       this.itemPrice = price;
   }   

}
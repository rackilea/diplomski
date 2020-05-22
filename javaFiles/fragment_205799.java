@Entity
@Table(name = "user_item")
public class UserItem implements Serializable {

   //Generate this like you are doing with your others.
   private String userItemUUID;

   @ManyToOne
   @JoinColumn(name="userUUID")
   private User user;

   @ManyToOne
   @JoinColumn(name="itemUUID")
   private Item item;

   private BigDecimal moneyCollect;

   private Date dateAdded = new Date();
}
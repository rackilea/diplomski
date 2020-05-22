@Entity
public class User implements Serializable {

   private String username;

   @OneToOne( optional = false, orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL )
   @JoinColumn(name = "bank_account_id")
   private BankAccount bankAccount;
   //.....
}
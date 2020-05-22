@Entity
 @Table(name="TB_Person")
 public class TB_Person {

     @Id
     private String CPF;

     @OneToOne
     @JoinColumn(name = "user_id") // <- table column constrained by fk_TB_Person_TB_User1
     private TB_User user;

     ...
 }
@Entity
@FilterDef(name="userRecipient", 
parameters=@ParamDef(name="userParam", type="PAKAGE.User" ))
@Table(name = "message_table", catalog = "your_db")
public class Message{

...
@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
@Filter(name = "userRecipient",condition="user = :userParam")
public List<MessageUser> msgUserList;
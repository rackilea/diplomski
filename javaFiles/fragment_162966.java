@Entity  
public class User {  
    @Column  
    @Type(type="com.youcompany.LowerCaseString")
    private String username;  
}
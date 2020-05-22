import javax.persistence.Entity;    
import com.avaje.ebean.annotation.Sql;  

@Entity  
@Sql  
public class Result {  

    String name;  
    Integer value;  
    String param1;
    String param2;
    String att1;
    String att2;
}
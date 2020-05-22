...  
import org.hibernate.annotations.Type;  
import org.hibernate.annotations.TypeDefs;  
import org.hibernate.annotations.TypeDef;  

@TypeDefs({  
    @TypeDef(  
        name="clob",  
        typeClass = foo.StringClobType.class  
    )  
})  
@Entity  
@Table(name="EA_COMMENTS")  
public class Comment extends SWDataObject implements JSONString, Serializable {  
...  
}
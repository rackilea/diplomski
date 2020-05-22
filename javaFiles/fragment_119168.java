@Entity  
public class ObjectAttribute {  
    @Id  
    private int id;  
    @Id  <------------------------ try to remove this annotation
    @ManyToOne  
    @JoinColumn(name="objectId")  
    private Object object;  
    private String name;  
}
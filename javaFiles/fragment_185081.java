@Entity  
@Table(name="authors")  
public class Author {  

    @Id  
    @GeneratedValue  
    private Integer id;  

    private String name;  

    @OneToOne(mappedBy="author", cascade=CascadeType.ALL)  
    private Biography biography;      
}
@Entity  
@Table(name="biographies")  
public class Biography {  

    @Id  
    @Column(name="id")  
    @GeneratedValue(generator="gen")  
    @GenericGenerator(name="gen", strategy="foreign",   
    parameters=@Parameter(name="property", value="author"))  
    private Integer id;  

    @OneToOne  
    @PrimaryKeyJoinColumn  
    private Author author;  
}
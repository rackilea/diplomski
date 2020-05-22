@Embeddable
public class MyCompositePK { 
    @Column
    private String fieldA;
    @Column
    private String fieldB;
}
@Entity 
public class MyBean { 
    @EmbeddedId
    private MyCompositePK id;
    @Column
    private String fieldC;
}
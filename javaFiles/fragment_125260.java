@Entity
public class RecursiveType implements Serializable {

    private static final long serialVersionUID = -2459343636539882731L;

    @Id
    public int id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="REC1_ID", referencedColumnName="ID")
    public RecursiveType rec1;    
    public Map<String, Map<RecursiveType, List<Map<RecursiveType, List<InnerTypes>>>>> rec2; //I really don't need to try and map this xD

    //getters and setters
}
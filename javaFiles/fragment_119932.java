@Entity
@Table(name="DOCUMENTS")
@IdClass(DocumentPK.class)
public class CustomerDocument implements Serializable{

    private static final long serialVersionUID = 6373600479711119252L;

    @Id
    @Column(name="P_ID", nullable=false)
    private String pId;

    @Id
    @Column(name="P_NAME", nullable=false)
    private String pName;

    private     String  p_code;

    /* Getters and setters */
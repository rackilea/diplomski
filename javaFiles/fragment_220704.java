@Entity
@Table(name = "eupass_pdffile", schema = "hrast")
public class PDFFile implements Serializable {

    private static final long serialVersionUID = -753514667628201960L;
    private long id;
    private byte[] pdfFile;
    private Long idCandidate;
    //@ManyToMany
    @JoinColumn(name="id_candidate") //or whatever your column name is.
    private Candidate candidate ;
}
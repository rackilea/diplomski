@Embeddable
public class MessageDescPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="messageid", nullable = false, insertable = false, updatable=false)
    private long message;

    @Column(name="languageid", nullable = false, insertable = false, updatable=false)
    private int language;
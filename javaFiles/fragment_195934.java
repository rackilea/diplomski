public class Tutorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TutorialPK tutorialPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "message")
    private String message;
    @MapsId("tutorialTypeId")
    @ManyToOne(optional = false)
    private TutorialType tutorialType;
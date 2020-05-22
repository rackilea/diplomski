@Embeddable
public class FestivalTranslationId implements Serializable {
    @Embedded
    private FestivalId festivalId;

    @Column(name = "LANG")
    private String lang;
    ...
}
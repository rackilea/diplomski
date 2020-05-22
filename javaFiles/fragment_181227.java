@Entity
@Table(name = "FESTIVAL_TRANSLATION")
public class FestivalTranslation {
    @EmbeddedId
    private FestivalTranslationId festivalTranslationId;

    @ManyToOne
    private Festival festival;
    ...
}
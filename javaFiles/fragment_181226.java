@Entity
@Table(name = "FESTIVAL")
public class Festival {
    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "ID"))
    private FestivalId festivalId;

    @MapsId(value = "festivalId")
    @OneToMany(mappedBy = "festival")
    @MapKey(name = "festivalTranslationId")
    private Map<String, FestivalTranslation> translations;
    ...
}
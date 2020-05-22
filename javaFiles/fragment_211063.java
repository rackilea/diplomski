@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="masterClass", discriminatorType=DiscriminatorType.INTEGER)
@Table(name="localizedDescriptions")
public class LocalizedDescriptions{

    private Integer id;
    private Locale locale;
    private String description;

        [Getters, Setters]
}
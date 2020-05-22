@Table
@Entity
public class Some {

    private Map<Locale, LocalizedSomeDescription> names = new HashMap<Locale, LocalizedSomeDescription>();

    @OneToMany
    @JoinColumn(name="master_id")
    @MapKeyColumn(name="locale")
    public Map<Locale, LocalizedSomeDescription> getDescriptions() {
        return descriptions;
    }

}
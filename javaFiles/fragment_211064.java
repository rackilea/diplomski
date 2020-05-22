@Entity
public class LocalizedSomeDescription extends LocalizedDescription {

    private Some master;

    /**
     * @return the master
     */
    @ManyToOne
    public Some getMaster() {
        return master;
    }
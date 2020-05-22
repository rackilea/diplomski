@Entity
public class MachineLine {

    @EmbeddedId
    private Id id;

    @MapsId("machineId") // maps machineId attribute of embedded id
    @ManyToOne
    private Machine machine;

    // ...

    @Embeddable
    public static class Id implements Serializable {
        private long machineId; // corresponds to PK type of Machine
        private long index;
        // ...
    }
}
@Entity
public class ReportDetails implements Serializable {
    // all attributes map by the relationship: AttributeOverride is not allowed
    @EmbeddedId
    private MachineLine.Id id;

    @MapsId
    @JoinColumns({
        @JoinColumn(name="machineId", referencedColumnName="machineId"),
        @JoinColumn(name="machineLineIndex", referencedColumnName="index")
    })
    @OneToOne
    private MachineLine machineLine;

    // ...
}
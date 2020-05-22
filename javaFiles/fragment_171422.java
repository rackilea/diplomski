@Entity
@Table(name = "target")
@AssociationOverrides({
        @AssociationOverride(name = "targetId.employeeId",
            joinColumns = @JoinColumn(name = "role_id")),
        @AssociationOverride(name = "targetId.applicationPeriodId",
            joinColumns = @JoinColumn(name = "ApplicationPeriod_id")),
        @AssociationOverride(name = "targetId.projectClassId",
                joinColumns = @JoinColumn(name = "project_class_id"))
})
public class Target implements Serializable {

    @EmbeddedId
    private TargetId targetId;

    private int target;

    public TargetId getTargetId() {
        return targetId;
    }

    public void setTargetId(TargetId targetId) {
        this.targetId = targetId;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Target() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Target)) return false;

        Target target = (Target) o;

        if (this.target != target.target) return false;
        if (targetId != null ? !targetId.equals(target.targetId) : target.targetId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = targetId != null ? targetId.hashCode() : 0;
        result = 31 * result + target;
        return result;
    }
}
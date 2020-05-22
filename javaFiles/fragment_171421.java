@Embeddable
public class TargetId implements Serializable {

    @Basic
    private Long employeeId;

    @Basic
    private Long applicationPeriodId;

    @Basic
    private Long projectClassId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getApplicationPeriodId() {
        return applicationPeriodId;
    }

    public void setApplicationPeriodId(Long applicationPeriodId) {
        this.applicationPeriodId = applicationPeriodId;
    }

    public Long getProjectClassId() {
        return projectClassId;
    }

    public void setProjectClassId(Long projectClassId) {
        this.projectClassId = projectClassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TargetId)) return false;

        TargetId targetId = (TargetId) o;

        if (applicationPeriodId != null ? !applicationPeriodId.equals(targetId.applicationPeriodId) : targetId.applicationPeriodId != null)
            return false;
        if (employeeId != null ? !employeeId.equals(targetId.employeeId) : targetId.employeeId != null) return false;
        if (projectClassId != null ? !projectClassId.equals(targetId.projectClassId) : targetId.projectClassId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (applicationPeriodId != null ? applicationPeriodId.hashCode() : 0);
        result = 31 * result + (projectClassId != null ? projectClassId.hashCode() : 0);
        return result;
    }
}
@Embeddable
public class EmployeeId implements Serializable {

    private Long companyId;

    private Long employeeId;

    public EmployeeId() {
    }

    public EmployeeId(Long companyId, Long employeeId) {
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeId)) return false;
        EmployeeId that = (EmployeeId) o;
        return Objects.equals(getCompanyId(), that.getCompanyId()) &&
                Objects.equals(getEmployeeId(), that.getEmployeeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyId(), getEmployeeId());
    }
}
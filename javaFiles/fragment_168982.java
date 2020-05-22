public class WorkstationRequest {
    private Class<? extends Workstation> workstationClass;

    public WorkstationRequest(Class<? extends Workstation> workstationClass) {
        this.workstationClass = workstationClass;
    }
}
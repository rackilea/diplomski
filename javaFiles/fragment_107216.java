public class DarfAssignmentProcessor extends AssignmentProcessor<DarfAssignment> {
    @Override
    public DarfAssignment loadAssignment(Integer assignmentId) {
        DarfAssignment assignment = (DarfAssignment) loadAssignment(assignmentId, DarfAssignment.class);
        return assignment;
    }
    @Override
    public boolean saveAssignment(DarfAssignment assignment) {
        return false;
    }
}
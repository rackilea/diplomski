public abstract class AssignmentProcessor<T extends Assignment>  {
    public abstract T loadAssignment(Integer assignmentId);
    public boolean saveAssignment(T assignment) {
        return false;
    }
    protected Assignment loadAssignment(Integer assignmentId, Class<T> clazz) {
        Assignment assignment = null;
        try {
            assignment = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BurstAssignment burstAssignment = SessionHelper.getSession().getBurstAssignment(assignmentId);
        assignment.setId(burstAssignment.getId());
        return assignment;
    }
}
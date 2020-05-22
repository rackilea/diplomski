class MyWorkflow extends Workflow {

    public MyWorkflow() {
        super();
    }

    public MyWorkflow(WorkflowEntity entity) {
        super(entity);
    }
}
public static Workflow factory(WorkflowEntity workflowEntity) {
    try {
        Class<?> clazz = Class.forName(workflowEntity.getClassName())
                .asSubclass(Workflow.class);
        Constructor<?> c = clazz.getConstructor(WorkflowEntity.class);
        Object workflowClass = c.newInstance(workflowEntity);
        return (Workflow) workflowClass;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}
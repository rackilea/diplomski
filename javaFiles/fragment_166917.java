@Inject
private ContextAssociationManager contextAssociationManager;

@Inject 
private TaskService taskService;

public void flushCachedVariables() {
  String taskId = contextAssociationManager.getTask().getId();
  taskService.setVariables(taskId, contextAssociationManager.getCachedVariables());
}
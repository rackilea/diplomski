ExecutionEntity executionEntity = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(executionId).singleResult();
if (executionEntity == null) {
    return null;
}
String parentId = executionEntity.getParentId();
boolean parentNotEmpty = StringUtils.isNotEmpty(parentId);
String superExecutionId = executionEntity.getSuperExecutionId();
boolean superNotEmpty = StringUtils.isNotEmpty(superExecutionId);
if (parentNotEmpty) {
    return getRootExecution(parentId);
} else if (superNotEmpty) {
    return getRootExecution(superExecutionId);
} else {
    return executionEntity;
}
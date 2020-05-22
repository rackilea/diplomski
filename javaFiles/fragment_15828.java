ProcessDefinition procDef  = repositoryService.createProcessDefinitionQuery().processDefinitionKey("idOfProcess").singleResult();
BpmnModelInstance bpmnModelInstance = repositoryService.getBpmnModelInstance(procDef.getId());

CallActivity callActivity = null;

Collection<Lane> lanes = bpmnModelInstance.getModelElementsByType(Lane.class);
// iterate the lanes
for (Lane lane : lanes) {
  // iterate the flownodes referenced by the lane:
  for (FlowNode flowNode : lane.getFlowNodeRefs()) {
    if("idOfCallactivity".equals(flowNode.getId())) {
      callActivity = (CallActivity) flowNode;
      break;
    }
  }
}


if(callActivity != null) {
  // work with callactivity
}
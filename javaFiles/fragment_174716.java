public void notify(DelegateExecution execution){
   ActivitiScriptNodeList assignees = execution.getVariable("bpm_assignees"); 
   for (ActivitiScriptNode personNode : assignees) {
       String username = personNode.getProperties().get("cm:userName");
       String email = personNode.getProperties().get("cm:email");
       // TODO Use this
   }
}
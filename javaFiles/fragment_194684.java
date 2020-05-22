@Test
  @Deployment(resources = "process.bpmn")
  public void testParsingAndDeployment() {
 }

  @Test
  @Deployment(resources = "process.bpmn")
  public void testHappyPath() {
      RuntimeService rs = processEngine().getRuntimeService();
      Map<String, Object> variables = new HashMap<>();
      variables.put("percentageCompletion", "11");
      ProcessInstance processInstance = rs.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);
      System.out.println(processInstance.isEnded() + ", " + processInstance.isSuspended());
      VariableInstance vi = processEngine().getRuntimeService().createVariableInstanceQuery().processInstanceIdIn(processInstance.getId()).variableName("percentageCompletion").singleResult();
      System.out.println(processInstance.isEnded() + ", " + processInstance.isSuspended());
      System.out.println("********* " + processEngine().getHistoryService().createHistoricDetailQuery().processInstanceId(processInstance.getProcessInstanceId()).count());

      String executionId = processEngine().getHistoryService().createHistoricDetailQuery().processInstanceId(processInstance.getProcessInstanceId()).list().get(0).getExecutionId();
      System.out.println("executionId " + executionId);

      List<HistoricVariableInstance> hvis = processEngine().getHistoryService().createHistoricVariableInstanceQuery().executionIdIn(executionId).list();
      System.out.println("------------ " + hvis.size());

      for (HistoricVariableInstance hi : hvis) {
          System.out.println(hi.getName() + " : "+ hi.getValue());
      }
  }
package org.camunda.bpm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;

public class AllActiveActivities {

  public Map<String, String> getAllActiveActivities(String processInstanceId) {
    // get engine services
    ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine()
    RuntimeService runtimeService = processEngine.getRuntimeService();
    RepositoryService repositoryService = processEngine.getRepositoryService();

    // get the process instance
    ProcessInstance processInstance =
        runtimeService.createProcessInstanceQuery()
            .processInstanceId(processInstanceId)
            .singleResult();

    HashMap<String, String> activityNameByActivityId = new HashMap<String, String>();

    // get all active activities of the process instance
    List<String> activeActivityIds =
        runtimeService.getActiveActivityIds(processInstance.getId());

    // get bpmn model of the process instance
    BpmnModelInstance bpmnModelInstance =
        repositoryService.getBpmnModelInstance(processInstance.getProcessDefinitionId());

    for (String activeActivityId : activeActivityIds) {
      // get the speaking name of each activity in the diagram
      ModelElementInstance modelElementById =
          bpmnModelInstance.getModelElementById(activeActivityId);
      String activityName = modelElementById.getAttributeValue("name");

      activityNameByActivityId.put(activeActivityId, activityName);
    }

    // map contains now all active activities
    return activityNameByActivityId;
  }

}
@RequestMapping(value = "/getTaskForCandidateGroup")
public List<Map<String, Object>> getTaskForCandidateGroup() {
List<Tasks> taskList = getTaskForCandidateGroup();

List<Map<String, Object>> customTaskList = new ArrayList<>();
    for (Task task : taskList) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("taskId", task.getId());
        map.put("taskDefinitionKey", task.getTaskDefinitionKey());
        map.put("taskName", task.getName());

        customTaskList.add(map);
    }
    return customTaskList;
@RequestMapping (value = "/task/create/{parentBoxId}/{taskTitle}/{taskDescription}", method=RequestMethod.GET)
    public @ResponseBody Map<String, Object> createTask(ModelMap model,
              @PathVariable(value="parentBoxId") String parentBoxId,
              @PathVariable(value="taskTitle") String taskTitle,
              @PathVariable(value="taskDescription") String taskDescription) {

    Map<String, Object> result = new HashMap<String, Object>();

    Tasks taskToBeReturned = null;
    Tasks task = new Tasks();
    task.setTitle(taskTitle);
    task.setDescription(taskDescription);
    Boxes parentBox = (Boxes)( boxService.getBoxById(Long.valueOf(parentBoxId)) ).getObject();
    taskService.setParent(task, parentBox);
    result = taskService.save(task);

    if(result.getIsSuccessful()){
        model.put("successMessages", result.getMessageList());
        Tasks savedTask = (Tasks)result.getObject();
        System.out.println("box saved title was " + savedTask.getTitle());
        taskToBeReturned = new Tasks();
        taskToBeReturned.setTitle(savedTask.getTitle());
        taskToBeReturned.setId(savedTask.getId());
        taskToBeReturned.setDescription(savedTask.getDescription());

    }else{
        model.put("errorMessages", result.getMessageList());
    }

    result.put("task", taskToBeReturned);
    result.put("model", model); // Add the model if needed
    return result;
}
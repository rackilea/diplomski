@RequestMapping (value = "/task/delete/{taskId}", method=RequestMethod.GET)
public @ResponseBody Map<String, Object> deleteTask(ModelMap model, @PathVariable(value="taskId") String taskId) {

    Map<String, Object> result = new HashMap<String, Object>();
    result = taskService.deleteTask(Long.parseLong(taskId));

    if (result.getIsSuccessful()) {
        model.put("successMessages", result.getMessageList());
        System.out.println("task deleted ------------------");

        result.put("result", "success");
        result.put("model", model); // Add the model if needed        

    }else{
        System.out.println("task deletion failed ---------------");
        model.put("errorMessages", result.getMessageList());

        result.put("result", "failure");
        result.put("model", model); // Add the model if needed  
    }
    return result;
}
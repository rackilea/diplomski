TaskObject taskObject = null;
while (rsu.next()) {
    taskObject = new TaskObject();

    taskObject.setTask(rsu.getString("mainTaskString"));
    //set remaining value

    //Add taskObject in List
    taskList.add(taskObject);
}
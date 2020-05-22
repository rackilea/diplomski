Task task1 = new Task();
task1.setPreviousTask(task0);
task0.setNextTask(task1);

//...
solution.computeAllArrivalTimes();
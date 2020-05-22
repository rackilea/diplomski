// the optionalRunnable can collect the data gathered by the tasks
CyclicBarrier b = new CyclicBarrier(numberOfTasks,optionalRunnable)

Task yourTaks = new Task(...., b);
// inside the run method call b.await() after the work is done;
executor.submit(yourTaks);
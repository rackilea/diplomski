while (!Thread.interrupted()) {
   Task task = getNextTask(queue);  
   doSomething(task);
}
System.out.println("The thread was interrupted while processing tasks.");
System.out.println("...stopped processing.");
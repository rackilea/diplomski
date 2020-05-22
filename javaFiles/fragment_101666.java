class MyTask implements Runnable { ... }

List<Runnable> tasks = new ArrayList<>();
tasks.add(new MyTask());

// Run all the tasks in the list
for (Runnable task : tasks) {
    task.run();
}
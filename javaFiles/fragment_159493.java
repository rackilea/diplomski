ListIterator<MyTask> reverseIterator = tasks.listIterator(tasks.size());
while (reverseIterator.hasPrevious()) {
   MyTask task = reverseIterator.previous();
   if (task.getTaskType() == type)
      return task;
}

return null; // Not found
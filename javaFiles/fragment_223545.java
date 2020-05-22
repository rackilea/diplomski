class TimeComparator implements Comparator<Task> {
        public int compare(Task task1, Task task2) {
            int compareResult = 0;
            if (task2.time < task1.time)
                compareResult = 1;
            else
                compareResult = -1;

            return compareResult;
        }
    }
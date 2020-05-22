public static int[] orderTasks (String[] lines){
    // parse
    int numTasks = Integer.parseInt(lines[0]);
    List<int[]> restrictions = new ArrayList<int[]>(lines.length-1);
    for (int i = 1; i < lines.length; i++){
        String[] strings = lines[i].split("<");
        restrictions.add(new int[]{Integer.parseInt(strings[0]), Integer.parseInt(strings[1])});
    }

    // ordered
    int[] tasks = new int[numTasks];
    int current = 0;

    Set<Integer> left = new HashSet<Integer>(numTasks);
    for (int i = 1; i <= numTasks; i++){
        left.add(i);
    }
    while (current < tasks.length){
        // these numbers can't be written yet
        Set<Integer> currentIteration = new HashSet<Integer>(left);
        for (int[] restriction : restrictions){
            // the second element has at least the first one as precondition
            currentIteration.remove(restriction[1]);
        }
        if (currentIteration.isEmpty()){
            // control for circular dependencies
            throw new IllegalArgumentException("There's circular dependencies");
        }
        for (Integer i : currentIteration){
            tasks[current++]=i;
        }
        // update tasks left
        left.removeAll(currentIteration);
        // update restrictions
        Iterator<int[]> iterator = restrictions.iterator();
        while (iterator.hasNext()){
            if (currentIteration.contains(iterator.next()[0])){
                iterator.remove();
            }
        }
    }
    return tasks;
}
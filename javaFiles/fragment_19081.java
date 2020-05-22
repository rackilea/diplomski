//---

ThreadGroup root = Thread.currentThread().getThreadGroup().getParent();

while (root.getParent() != null)
  root = root.getParent();

findAllThread(root,0);

//---

public static findAllThread(ThreadGroup threadGroup, int level){

    int actCount = threadGroup.activeCount();
    Thread[] threads = new Thread[actCount*2];
    actCount = threadGroup.enumerate(threads, false);


    for (int i=0; i<actCount; i++) {
        Thread thread = threads[i];
        thread.interrupt();
    }

    int groupCount = threadGroup.activeGroupCount();
    ThreadGroup[] groups = new ThreadGroup[numGroups*2];
    groupCount = threadGroup.enumerate(groups, false);

    for (int i=0; i<groupCount; i++) 
        findAllThread(groups[i], level+1);

//---
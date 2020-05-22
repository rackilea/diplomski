Iterator<ServerThread> iterator = threadPool.iterator();
 while (iterator.hasNext()) {
     ServerThread thread = iterator.next();
     if (!thread.isAlive()) {
        // remove it from the linked list
        iterator.remove();
     }
 }
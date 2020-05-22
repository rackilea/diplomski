public void canEat(String name) {
   lock.lock();
   try {
       eaters.add(name);
       if (eaters.size() > 0) {
          canFeed.signal();
       }
   } finally {
       lock.unlock();
   }
}
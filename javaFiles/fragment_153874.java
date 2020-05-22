private final Lock lock = new ReentrantLock();
public void stopAllPlaying(int fadeDurationInMs)
{
    lock.lock();
    try{
      for(PlayThread thread : threadMap.values()) {
          if(thread != null) {
              thread.fadeOut(fadeDurationInMs);
          }
      }
      threadMap.clear();
    }
    finally{
    lock.unlock();
    }
}
public class ObjectContainer {
    volatile boolean isSetupDone = false;
    Object o;
}

static ConcurrentHashMap<String, ObjectContainer> containers = 
    new ConcurrentHashMap<String, ObjectContainer>();

public Object getInstance(String groupId) {
  ObjectContainer oc = containers.get(groupId);
  if (oc == null) {
    // it's enough to sync on the map, don't need the whole class
    synchronized(containers) {
      // double-check not to overwrite the created object
      if (!containers.containsKey(groupId))
        oc = new ObjectContainer();
        containers.put(groupId, oc);
      } else {
        // if another thread already created, then use that
        oc = containers.get(groupId);
      }
    } // leave the class-level sync block
  }

  // here we have a valid ObjectContainer, but may not have been initialized

  // same doublechecking for object initialization
  if(!oc.isSetupDone) {
    // now syncing on the ObjectContainer only
    synchronized(oc) {
      if(!oc.isSetupDone) {
        oc.o = new String("typically a more complicated operation"));
        oc.isSetupDone = true;
      }        
    }
  }
  return oc.o;
}
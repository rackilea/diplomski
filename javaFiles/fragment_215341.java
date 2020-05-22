MyObject obj = getObject(name);
synchronized(obj) {
   obj.workII();
}
if (obj.decWIP() == 0) { // finished with this work and all others
   synchronized(map) {
      // double-check the value because we checked previously without the map lock
      if (obj.getWIP() == 0) {
         map.remove(obj);
      }
   }
}
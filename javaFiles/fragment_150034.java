for (Iterator<GameObject> iter = INSTANCE.getObjects().values(); iter.hasNext(); ;) {
     GameObject object = iter.next();
     if (someCondition(object)) {
         iter.remove();
     }
 }
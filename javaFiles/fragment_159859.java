@Override
 public void preFlush(Iterator entities) {
    List list= IteratorUtils.toList(entities); 
    for(Object o : list){...}

 }
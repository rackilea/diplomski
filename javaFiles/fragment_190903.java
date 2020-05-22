instrumentMap.compute(threadName, (tn, instrumentList) -> {
  if (instrumentList == null) {
    instrumentList = new ArrayList<>();
  }

  if(instrumentList.size() >= batchSize -1) {
    instrumentList.addAll(entityList); 
    recordSaver.persist(instrumentList); 
    instrumentList.clear();
  } else {
    instrumentList.addAll(entityList);
  }

  return instrumentList;
});
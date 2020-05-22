for (EntityB entityB : entityBList) {
  try {
    addEntityB(entityAId, entityB);
  }
  catch(Exception e){
    log(e);
  }
}
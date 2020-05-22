if(local.getStorage > amount){
  reservator = localReservatorProvider.get();  // no dependencies!
}
else if(local.getStorage ==0 && external.getStorage > amount){
  reservator = externalReservatorProvider.get();
}
else if((local.getStorage + external.getStorage) > amount){
  reservator = mixedReservatorProvider.get();
}
else{
  return false;
}
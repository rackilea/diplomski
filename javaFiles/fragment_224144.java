while (itr.hasNext()) {
  Integer i1 = (Integer) itr.next();
  if(itr.hasNext()){
    mapOfAccounts.put(i1, tempAccountsMap.get((Integer) itr.next()));
  }
}
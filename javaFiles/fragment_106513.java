public Set<Integer> findDuplicates(List<Integer> listContainingDuplicates)
{ 
  final Set<Integer> setToReturn = new HashSet(); 
  final Set<Integer> set1 = new HashSet();

  for (Integer yourInt : listContainingDuplicates)
  {
   if (!set1.add(yourInt))
   {
    setToReturn.add(yourInt);
   }
  }
  return setToReturn;
}
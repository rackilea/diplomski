public List<Integer> toList() 
{
   List<Integer> newList = new List<Integer>();
   newList.add(this.data);
   if(left != null)
      newList.addAll(left.toList());
   if(right != null)
      newList.addAll(right.toList());
   return newList;
}
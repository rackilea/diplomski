public boolean contains(Comparable item)
{
     return containsHelper(this.first, Comparable item);
}

private boolean containsHelper(Node node, Comparable item)
{
    //base case
    if(node == null)
    {   
         return false;
    }
    else
    {
         if(node.data.compareTo(item) == 0)
         {
             return true;
         }

         return containsHelper(node.next, item);
    }


}
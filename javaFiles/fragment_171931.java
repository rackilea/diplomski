class Node<T>
{
   T val;
   Node left = null, right = null;

   public void fill(int index, T [] vals)
   {
      val = vals[index];
      if (vals.length > 2*index+1)
      {
         left = new Node<T>();
         left.fill(2*index+1, vals);
      }
      if (vals.length > 2*index+2)
      {
         right = new Node<T>();
         right.fill(2*index+2, vals);
      }
   }
}
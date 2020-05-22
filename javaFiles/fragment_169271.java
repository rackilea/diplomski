public static <E> BTNode<E> treeCopy(BTNode<E> source)
{
     if(source == null)
         return null;
     else
     {
         BTNode<E> left = BTNode.treeCopy(source.left);
         BTNode<E> right = BTNode.treeCopy(source.right);
         return new BTNode(source.data, left, right);
     }
}
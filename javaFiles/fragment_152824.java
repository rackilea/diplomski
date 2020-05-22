private boolean is234(Node x)
{         
   if (x == null)
      return true;
   // Note the TD234 check is here because we also want this method to verify 2-3 trees
   if (isRed(x.right))
      return species == TD234 && isRed(x.left);

   if (!isRed(x.right))
      return true;

   return is234(x.left) && is234(x.right);
}
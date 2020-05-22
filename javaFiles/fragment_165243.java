ExpNode current = root;
while(current != null)
{
   if(current.left == null)
   {
       ExpNode temp = new ExpNode(op, null, null);    
       current.left = temp;
       break;
   }

   else if(current.right == null)
   {
       ExpNode temp = new ExpNode(op, null, null);
       current.right = temp;
       break;
   }

   else
       current = current.left;
}
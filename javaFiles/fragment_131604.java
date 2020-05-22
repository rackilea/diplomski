private static void recursiveMethod(ComponentObject root)
{
   int numChildren = findNumChildren(root);
   System.out.println("Recursive method: " + numChildren);
}

// The actual recursive method.
private static int findNumChildren(ComponentObject root)
{
   if (root instanceof CategoryObject)
   {
      CategoryObject parent = (CategoryObject) root;
      int numChildren = 0;
      for (int i = 0; i < parent.getNumDirectChildren(); i++)
      {
         ComponentObject child = parent.getChild(i);
         // One for the child itself, plus its children.
         numChildren += 1 + findNumChildren(child);
      }
      return numChildren;
   }

   // Base case: NonCategoryObjects have no children.
   return 0;
}
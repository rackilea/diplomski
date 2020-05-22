ComponentObject foundRoot = null;
   for (ComponentObject c : components)
   {
      CategoryObject parent = c.getParent();
      if (parent == null)
      {
         foundRoot = c;
      }
      else
      {
         parent.addChild(c);
      }
   }
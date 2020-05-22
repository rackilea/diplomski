public static <T extends Container> T findParent(Component comp, Class<T> clazz)  {
      if (comp == null)
         return null;
      if (clazz.isInstance(comp))
         return (clazz.cast(comp));
      else
         return findParent(comp.getParent(), clazz);     
   }
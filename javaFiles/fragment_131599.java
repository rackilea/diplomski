public abstract class ComponentObject
{
   private CategoryObject myParent;

   protected ComponentObject(CategoryObject parent)
   {
      myParent = parent;
   }

   public CategoryObject getParent()
   {
      return myParent;
   }

   public abstract int getNumChildren();
}
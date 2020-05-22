public class NonCategoryObject extends ComponentObject
{
   public NonCategoryObject(CategoryObject parent)
   {
      super(parent);
   }

   @Override
   public int getNumChildren()
   {
      return 0;
   }
}
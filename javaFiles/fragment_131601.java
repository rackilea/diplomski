public class CategoryObject extends ComponentObject
{
   private ArrayList<ComponentObject> myChildren;

   public CategoryObject(CategoryObject parent)
   {
      super(parent);
      myChildren = new ArrayList<ComponentObject>();
   }

   public void addChild(ComponentObject child)
   {
      myChildren.add(child);
   }

   public ComponentObject getChild(int index)
   {
      return myChildren.get(index);
   }

   public int getNumDirectChildren()
   {
      return myChildren.size();
   }

   @Override
   public int getNumChildren()
   {
      int numChildren = 0;
      for (ComponentObject child : myChildren)
      {
         // One for the child itself, plus add any of the child's children.
         numChildren += 1 + child.getNumChildren();
      }
      return numChildren;
   }
}
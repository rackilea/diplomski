public static void main(String[] args)
{
   // Create a tree structure, parent information only.
   CategoryObject root = new CategoryObject(null);
   CategoryObject categoryOne = new CategoryObject(root);
   CategoryObject categoryTwo = new CategoryObject(root);
   CategoryObject categoryThree = new CategoryObject(root);
   CategoryObject categoryOneOne = new CategoryObject(categoryOne);
   CategoryObject categoryOneTwo = new CategoryObject(categoryOne);
   CategoryObject categoryOneThree = new CategoryObject(categoryOne);
   NonCategoryObject leafOneFour = new NonCategoryObject(categoryOne);
   NonCategoryObject leafOneOneOne = new NonCategoryObject(categoryOneOne);
   NonCategoryObject leafOneOneTwo = new NonCategoryObject(categoryOneTwo);
   NonCategoryObject leafOneTwoOne  = new NonCategoryObject(categoryOneTwo);
   NonCategoryObject leafOneThreeOne  = new NonCategoryObject(categoryOneThree);
   NonCategoryObject leafTwoOne = new NonCategoryObject(categoryTwo);
   NonCategoryObject leafThreeOne = new NonCategoryObject(categoryThree);

   // We're given the ArrayList
   ArrayList<ComponentObject> components = new ArrayList<ComponentObject>();
   // The order doesn't matter.
   components.addAll(Arrays.asList(leafOneFour, leafOneOneTwo, leafOneThreeOne,
      categoryOne, categoryOneOne, categoryOneThree, root, leafThreeOne,
      leafOneOneOne, categoryThree, leafOneTwoOne, leafTwoOne,
      categoryTwo, categoryOneTwo));
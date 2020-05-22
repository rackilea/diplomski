public static boolean Test()
   {
      return Test(System.nanoTime());
   }
   public static boolean Test(long seed)
   {
      StdOut.println("Seeding test with: " + seed);
      Random r = new Random(seed);
      RedBlackBST<Integer, Integer> llrb = new RedBlackBST<Integer,Integer>(TD234);
      ArrayList<Integer> treeValues = new ArrayList<Integer>();
      for (int i = 0; i < 1000; i++)
      {
         int val = r.nextInt();
         if (!treeValues.contains(val))
         {
            treeValues.add(val);
            llrb.put(val, val);
         }
         else
            i--;
      }
      for (int i = 0; i < treeValues.size(); i++)
      {
         llrb.delete(treeValues.get(i));
         if (!llrb.check())
         {
            return false;
         }
//         StdDraw.clear(Color.GRAY);
//         llrb.draw(.95, .0025, .008);
      }
      return true;
   }
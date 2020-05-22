List<Integer>[] folds = new List<Integer>[5];
for(int i = 0; i < 5; i++)
{
   folds[i] = new LinkedList<Integer>();
}

for (int i = 0; i < nonRatedItems.size(); i++)
{
   folds[i % 5].add(nonRatedItems.get(i));
}
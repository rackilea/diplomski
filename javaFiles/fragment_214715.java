ArrayList<Integer> set[] = new ArrayList[max];
//Initialize each set, add element into set
for(int i = 0; i < max; i++)
   set[i] = new ArrayList();
   set[i].add(i);
//For step 2
set[boss[u]].addAll(set[boss[v]]);
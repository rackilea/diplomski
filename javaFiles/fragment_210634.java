ArrayList<...> list = ...;

for (int i = 0; i < list.size(); ) {
   if (shouldBeRemoved)
       list.remove(i);
   else
       ++ i;
}
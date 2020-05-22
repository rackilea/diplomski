//ArrayList<ArrayList<Item>> items;
//int columnHeight;
for( ArrayList<Item> arr : items )
  for( int i = columnHeight - 2; i >= 0; i-- )
    if ( arr.get(i) == null ) //or arr.get(i).getIcon()==null or whatever
      for( int j = i; j < columnHeight - 1; j++ )
        arr.set(j, arr.get(j+1));
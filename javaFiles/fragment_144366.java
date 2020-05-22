//Item[][] items;
for( Item[] arr : items )
  for( int i = arr.length - 2; i >= 0; i-- )
    if ( arr[i] == null ) // or arr[i].getBack().getIcon() == null or whatever
      for( int j = i; j < arr.length - 1; j++ )
        arr[j] = arr[j+1];
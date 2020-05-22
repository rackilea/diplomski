public static Integer[] mode(int a[]){
  List<Integer> modes = new ArrayList<Integer>(  );
  int maxCount=0;   
  for (int i = 0; i < a.length; ++i){
    int count = 0;
    for (int j = 0; j < a.length; ++j){
      if (a[j] == a[i]) ++count;
    }
    if (count > maxCount){
      maxCount = count;
      modes.clear();
      modes.add( a[i] );
    } else if ( count == maxCount ){
      modes.add( a[i] );
    }
  }
  return modes.toArray( new Integer[modes.size()] );
}
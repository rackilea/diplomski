SortedSet<Integer> numbers = new TreeSet<Integer>();

numbers.add( 1 );
numbers.add( 2 );
numbers.add( 3 );
numbers.add( 6 );
numbers.add( 7 );
numbers.add( 10 );

Integer start = null;
Integer end = null;

for( Integer num : numbers ) {
  //initialize
  if( start == null || end == null ) {
    start = num;
    end = num;
  }
  //next number in range
  else if( end.equals( num - 1 ) ) {
    end = num;
  }
  //there's a gap
  else  {
    //range length 1
    if( start.equals( end )) {
      System.out.print(start + ",");
    }
    //range length 2
    else if ( start.equals( end - 1 )) {
      System.out.print(start + "," + end + ",");
    }
    //range lenth 2+
    else {
      System.out.print(start + "-" + end + ",");
    }

    start = num;
    end = num;
  }
}

if( start.equals( end )) {
  System.out.print(start);
}
else if ( start.equals( end - 1 )) {
  System.out.print(start + "," + end );
}
else {
  System.out.print(start + "-" + end);
}
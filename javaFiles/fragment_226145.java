SortedSet<String> s = new TreeSet<String>(new Comparator<String>() {
  public int compare( String s1, String s2 ) {
    return s1.compareToIgnoreCase( s2 );
  }

});


s.add( "Erich" );
s.add( "Erica" );
s.add( "Erin" );
s.add( "Dave" );
s.add( "Thomas" );

SortedSet<String> result = s.subSet( "e", "e" + Character.MAX_VALUE ); //"e" represents the user input
System.out.println(result);//prints [Erica, Erich, Erin]

result = s.subSet( "Eric", "Eric" + Character.MAX_VALUE );
System.out.println(result); //prints [Erica, Erich]

result = s.subSet( "Erich", "Erich" + Character.MAX_VALUE );
System.out.println(result); //prints [Erich]
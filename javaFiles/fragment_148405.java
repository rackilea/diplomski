System.out.println( "key---------" + key );

for ( String value : values ) {

  // I used `String` instead of your `Text` type
  // so I do not need this line
  // String v = value.toString();

  System.out.println( "v---------------" + value );

  // if the value is not present, add it!
  // each value will be added once!
  if ( !valueCounterMap.containsKey( value ) )
    valueCounterMap.put( value, 1 );

  // if the value is already present, just 
  // increment its counter by 1
  else {

      Integer counter = valueCounterMap.get( value );
      valueCounterMap.put( value, ++counter );
  }
}

System.out.println( "getVal-----------" + valueCounterMap );
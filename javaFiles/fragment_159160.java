String input = "test\n" +
        "t,b\n" +
        "45,49\n" +
        "31,34,38,34,56,23,,,,3,23,23653,3875,3.7,8.5,2.5,7.8,2., 6 6 6 6 ,\n" +
        ",\n" +
        ".\n" +
        ".,/;,jm.m.,,n ,sdsd, 3,2m54,2 4,2m,ar ,SSD A,,B,4D,CE,S4,D,2343ES,SD\n";

Pattern p = Pattern.compile( "(?<=,|\\n)\\s*(\\d+(?:\\.\\d+)?)\\s*(?=,|\\n)" );    

Matcher m = p.matcher( input );

List<String> numbers = new ArrayList<String>();

while(m.find())
{
  numbers.add( m.group( 1 ) );
}

System.out.println(Arrays.toString( numbers.toArray() ));

//prints: [45, 49, 31, 34, 38, 34, 56, 23, 3, 23, 23653, 3875, 3.7, 8.5, 2.5, 7.8, 3]
//removing the faction group: [45, 49, 31, 34, 38, 34, 56, 23, 3, 23, 23653, 3875, 3]
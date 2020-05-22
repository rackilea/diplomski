String input = "ABC999DEF999XYZ";

//find numbers
Pattern p = Pattern.compile( "[0-9]+" );    
Matcher m = p.matcher( input );   
StringBuffer sb = new StringBuffer();

//loop through all found groups
while( m.find() )
{
  //get the length of the current number
  int minLength = m.group().length();

  //parse the found number, increment and reformat it to the given min length
  String format = "%0"+minLength+"d";
  String incrementedNumber = String.format( format, Integer.parseInt( m.group() ) + 1 );

  //append the match and all text before to the StringBuffer
  m.appendReplacement( sb, incrementedNumber );
}

//append the rest of the input to the StringBuffer
m.appendTail( sb );

//prints ABC1000DEF1000XYZ
System.out.println( sb );
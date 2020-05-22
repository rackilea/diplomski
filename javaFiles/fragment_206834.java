//your Eintraege
List<String> entries = ...; 

//compile the pattern only once
Pattern startPattern= Pattern.compile("^=== (.+) ===");

//use a StringBuilder for better performance
StringBuilder entry = new StringBuilder();  
boolean inEntry = false;

for (String line : dr.getAllLines()){   
  //you could also create the matcher outside and call matcher.reset(line) instead
  Matcher matcher = startPattern.matcher( line );

  if( matcher.find() ) {
    if( inEntry ) {
      //we're in an entry already so add the current and start a new one
      entries.add( entry.toString() );
      entry.clear();
    }

    //now we're definitely in an entry
    inEntry = true;
  }
  //no entry start but in an entry already 
  else if( inEntry ) {
    //apply whatever replacements you want and add the line to the current entry
    entry.append( line.replace("foo", "bar" ) );
  }
}

//if we're still in an entry here we need to add it as it didn't already happen in the loop
if( inEntry ) {
   entries.add( entry.toString() );
   entry.clear();
}
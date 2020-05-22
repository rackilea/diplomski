String input = "        EDIT        domain1.mv          Starter          example.domain1.net.mv     \n" +
               "        DELETE        long-domain1.mv          Silver          long-example.long-domain1.net.mv     \n" +
               "        ADD        short-domain1.mv          ADSL Business          ex.sdomain1.net.mv     \n";

//step 1: split the input into lines
String[] lines = input.split( "\n" );

//step 2: build a regular expression to check the line format and extract the domains - which are the (\S+) parts
Pattern pattern = Pattern.compile( "^\\s*(?:ADD|EDIT|DELETE)\\s+(\\S+)\\s+(?:Domain|Starter|Silver|Gold|ADSL Business|Pro|Lite|Standard|ADSL Multi|Pro Plus)\\s+(\\S+)\\s*$" );


List<String[]> lineList = new LinkedList<>();
int maxLengthDomain = 0;
int maxLengthTargetDomain = 0;

for( String line : lines )
{
  //step 2: check the line
  Matcher matcher = pattern.matcher( line );
  if( matcher.matches() ) {
    //step 2: extract the domains
    String domain = matcher.group( 1 );
    String targetDomain = matcher.group( 2 );

    //step 3: get the maximum length of the domains
    maxLengthDomain = Math.max( maxLengthDomain, domain.length() );
    maxLengthTargetDomain = Math.max( maxLengthTargetDomain, targetDomain.length() );

    lineList.add( new String[] { domain, targetDomain } );
  }
}

//step 4: build the format string with variable lengths
String formatString = String.format( "%%-%ds in      ns   %%-%ds", maxLengthDomain + 5, maxLengthTargetDomain + 2 );

//step 5: build the output
for( String[] line : lineList ) {
  System.out.println( String.format( formatString, line[0] + ".", line[1] + "." ) );
}
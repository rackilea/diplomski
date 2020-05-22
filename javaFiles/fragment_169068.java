public class Filter {
  Set<Character> keys = new HashSet<>();
  PrintWriter osw; 
  void checkAndDump( List<String> lines ) throws Exception {
    if( lines.size() >= 1 &&
        ! keys.contains( lines.get(0).charAt(0) ) ){
      for( String s: lines ){
        osw.println( s );
      }
      osw.println();
    }
    lines.clear();
  }

  void filter( String inpath, String outpath ) throws Exception {
    BufferedReader lr = new BufferedReader( new FileReader( inpath ) );
    osw = new PrintWriter( new FileOutputStream( outpath ) );
    String line;
    List<String> lines = new ArrayList<>();
    while( (line = lr.readLine()) != null ){
      if( line.length() > 0 ){
        lines.add( line );
      } else {
        checkAndDump( lines );
      }
    }
    checkAndDump( lines );
    osw.close();
    lr.close();
  }

  void fillSet( String path ) throws Exception {
    BufferedReader br = new BufferedReader( new FileReader( path ) );
    String line;
    while( (line = br.readLine()) != null ){
      if( line.length() > 0 ){
        keys.add( line.charAt(0) );
      }
    }
    br.close();
  }    

  public static void main( String[] args ) throws Exception {
    Filter f = new Filter();
    f.fillSet( "kraftwerk.txt" );
    f.filter( "love.txt", "lv.txt" );
  }
}
class Test {
  String a = "abc" ;
  StringBuilder buffer = new StringBuilder() ;

  public void normal() {
    buffer.append( "abc" ) ;
    buffer.append( "abc" ) ;
  }

  public void clever() {
    buffer.append( a ) ;
    buffer.append( a ) ;
  }
}
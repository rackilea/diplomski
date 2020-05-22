void start() : {String s ; } {
    (
        s = comment()  {System.out.println(s); }
    )*
}

String comment() :
{   Token t ;
    StringBuffer b = new StringBuffer() ;
}
{  <START_BLOCK_COMMENT>
   (
         t=<CHAR_IN_COMMENT>  {b.append( t.image ) ; }
   )*
   <END_BLOCK_COMMENT>
   {return b.toString() ; }
}
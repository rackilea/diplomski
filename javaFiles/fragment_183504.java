Scanner input = new Scanner(System.in);
String s = null;
while ( true )
{
   s = input.nextLine();
   if( !s.equals("\\n") ) 
      break;
}
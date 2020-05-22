public class NameTest {
   public static void main( String args[] ) {
      testName( "" );
      testName( "donald,tramp" );
      testName( "tramp,donald" );
      testName( "donald tramp" );
      testName( "tramp donald" );
   }

   public static void testName( String name ) {
      String subnamef="",subnamel="";
      //System.out.println("Enter name->");
      System.out.println("----- testName(): name=<"+name+">");0
      //name = scan.next();
      char space = ' ';
      if(name.indexOf(space)!=-1){
         name.replace(space, ',');
         System.out.println("testName(): replacing space, after: name=<"+name+">");
      }
      int placehold = name.indexOf(',');
      System.out.println("testName(): placehold="+placehold);

      // So... what do you want to do if placehold is -1 ?
      subnamef = name.substring(0,placehold );
      System.out.println("testName(): subnamef="+subnamef);
      subnamel = name.substring(placehold);
      System.out.println("testName(): subnamel="+subnamel);

      String name2 = subnamel+", "+subnamef;
      System.out.println("intput:  name=<"+name+">");
      System.out.println("result: name2=<"+name2+">");
   }
}
public class MyDecorator implements CSVCellDecorator
{
   public String decorate( int position, Map<Integer, String> srcLine )
   {
      // here add your custom logic to check and if applies return your default vendor code, otherwise return the given input value
      //String parsedValue=srcLine.get(position);
      //return parsedValue+"modified"; // some decoration stuff
   }
}
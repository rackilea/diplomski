public static <T> List<T> makeList() {
      List<T> list = (List<T>) new ArrayList();
      return list;
   }

//...
{
   List<String> list = makeList();
   list.add( "Howdy" );
}
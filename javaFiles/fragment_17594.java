import java.util.Arrays;
import java.util.Comparator;

public class ArraySort
{
  public static void main(String[] args)
  {
     String[][] data = new String[][]
         {
             new String[] { "Casablanca", "Warner Brothers", "1942" },
             new String[] { "Citizen Kane", "RKO Pictures", "1941" },
             new String[] { "Singin' in the Rain", "MGM", "1952" },
             new String[] { "The Wizard of OZ", "MGM", "1930"},
             new String[] { "AaaaaThe Wizard of OZ", "MGM", "1943"}
         };

     Arrays.sort(data, new Comparator<String[]>() {

        @Override
        public int compare(final String[] entry1, final String[] entry2) {
            final String field1 = entry1[0];
            final String field2 = entry2[0];
            return field1.compareTo(field2);
        }
     });

     print(data);

     System.out.println();

     Arrays.sort(data, new SortByDate());

     print(data);

     System.out.println();

     Arrays.sort(data, new SortByCompany());

     print(data);
  }

  public static void print(String[][] data){
    for (String[] array : data){
      for (String s : array){
        System.out.print(s + " ");
      }
      System.out.println();
    } 
  }

}

public class SortByDate implements Comparator<String[]>{
  @Override
  public int compare(final String[] entry1, final String[] entry2) {
    final String field1 = entry1[2];
    final String field2 = entry2[2];
    return field1.compareTo(field2);
  }
}

public class SortByCompany implements Comparator<String[]>{
  @Override
  public int compare(final String[] entry1, final String[] entry2) {
    final String field1 = entry1[1];
    final String field2 = entry2[1];
    return field1.compareTo(field2);
  }
}
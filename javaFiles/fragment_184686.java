//For this example I am creating an interface that will serve as predicate on my method
public interface IFilter
{
   int[] apply(int[] data);
}

//Methods that follow the same rule for return type and parameter type from IFilter may be referenced as IFilter
public class FilterCollection
{
    public static int[] median(int[]) {...}
    public int[] mean(int[]) {...}
    public void test() {...}
}

//The class that we are working on and has the method that uses an IFilter-like method as reference
public class Sample
{
   public static void main(String[] args)
   {
       FilterCollection f = new FilterCollection();
       int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};

      //Static method reference or object method reference
      data = filterByMethod(data, FilterCollection::median);
      data = filterByMethod(data, f::mean);

      //This one won't work as IFilter type
      //data = filterByMethod(data, f::test); 
   }

   public static int[] filterByMethod(int[] data, IFilter filter)
   {
       return filter.apply(data);
   }

}
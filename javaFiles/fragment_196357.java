public class DataSet<T implements Comparable>
{
 private T maximum;
 private T least;
 private T count;


 public void add(T x)
 {

   if(count == 0){
     least = x;
     maximum = x;
   }
   else if(least.compareTo(x) > 0)
     least = x;
   else if(maximum.compareTo(x) < 0)
     maximum = x;
   count++;
 }

 public T getMaximum()
 {
  return maximum;
 }

 public T getLeast()
 {
   return least;
 }

 }
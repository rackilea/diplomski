public class DataSet implements Comparable<DataSet>  
{  
 private String maximum;  
 private String least;  
 private int count;  
 private int answer;  

 public void add(String x)  
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

 public int compareTo(DataSet anObject)  
 {  
     // I don't really know how you want this to work.
     // Come up with your own criteria on what makes a DataSet greater or less than
     // another one.
     count - anObject.count
 }  

 // Good practice to include this if you're doing a compareTo.
 @Override
 public boolean equals(Object other)
 {
     return (other instanceof DataSet) && compareTo((DataSet)other) == 0;
 }

 public String getMaximum()  
 {  
  return maximum;  
 }  

 public String getLeast()  
 {  
   return least;  
 }  
}
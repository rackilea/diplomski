public class A <E extends Comparable<? super E>> implements B<E>
{
     private E[] myArray;


     public A()
     {
         myArray = (E[]) new Comparable[5]; 
     }    

}
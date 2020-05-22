import java.util.Comparator;
import java.lang.reflect.Method;

public class ObjectComparator<T> implements Comparator<T>{

   private String field;
   private String order;
   private Method method;
   private Class<T> cls;

   public ObjectComparator(String field, String order, Class<T> c){
       this.field = field;
       this.order = order;
       this.cls = c; 
       init();
   }

   private void init(){
       String field_name = "get"+field.substring(0,1).toUpperCase()+field.substring(1);
       try{
          method = cls.getDeclaredMethod(field_name,new Class[]{});
       }
       catch(Exception ex){
          System.err.println("No Such Method Found!");
       }        
   }
   @SuppressWarnings("unchecked")
   public int compare(T o1, T o2) {
        try{    
          Object o1_ = method.invoke(o1,new Object[]{});
          Object o2_ = method.invoke(o2,new Object[]{});
          //Move all objects with null field values
          //to the end of the list regardless of sorting order.
          if(o1_== null) return 1;
          else if(o2_== null) return -1;
           //////////////////////////////////
          if (order.equalsIgnoreCase("asc"))                
              return ((Comparable<Object>)o1_).compareTo(o2_);    
          else 
              return ((Comparable<Object>)o2_).compareTo(o1_);   
       }
       catch (Exception ex)
       {
           System.err.println("error sorting");
           return 0;
       }        
   }
}
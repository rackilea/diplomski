import java.lang.reflect.Field;
import java.util.Date;


public class StackExample {

    private Integer field1 = 3;
    private String field2 = "Something";
    private Date field3;

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        StackExample se = new StackExample();

        Field[] fields = se.getClass().getDeclaredFields();

        for(Field f:fields){
            if(!f.isAccessible()){
                f.setAccessible(true);
                Class<?> type = f.getType();

                if(type.equals(Integer.class)){
                    f.set(se, 100); //Set Default value
                }else if(type.equals(String.class)){
                    f.set(se, "Default");
                }else if (type.equals(Date.class)){
                    f.set(se, new Date());
                }
                f.setAccessible(false);
            }
            System.out.println(f.get(se)); //print fields with reflection
        }
    }
}
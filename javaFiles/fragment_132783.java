import java.lang.reflect.Field;

public class ObjectToPostStringbyReflection {


    public String getPostParamString(Object o) throws IllegalArgumentException, IllegalAccessException{
        Class<? extends Object> clazz = o.getClass();
        StringBuilder sb = new StringBuilder();
        for(Field f : clazz.getDeclaredFields()){
            f.setAccessible(true);
            if(!sb.toString().isEmpty()){
                sb.append("&");
            }
            sb.append(f.getName())
                .append("=")
                .append(f.get(o));
        }
        return sb.toString();
    }

    /**
     * @param args
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        // TODO Auto-generated method stub
        User user = new User();
        user.setName("John");
        user.setAddress("address");
        user.setAge("18");
        ObjectToPostStringbyReflection reflector = new ObjectToPostStringbyReflection();
        System.out.println(reflector.getPostParamString(user));
    }
}
import java.lang.reflect;

public static Object getArray(Object value){

    if (value != null && value.getClass().isArray()){
       return Array.getLength(value) == 0 ? null : Array.get(value, 0);
    }
    return value;
}
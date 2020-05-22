//in controller
import java.lang.reflect.*

//in show action or whichever makes sense
Field field = Cocimiento.class.getDeclaredField("producto");
ParameterizedType pt = (ParameterizedType) field.getGenericType();
Type concreteType = pt.getActualTypeArguments()[0];
println concreteType.getName()
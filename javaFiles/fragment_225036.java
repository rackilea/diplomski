package SalesUnitsIntoCarton.mySolution;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilityReflections {
    private static final Object[] EMPTY = {};

    /**
     * This method returns a value, returned by the method of a private inner class, of a given object instance.
     *
     * @param outerClassInstance This parameter needs to be an instance of the outer class that contains the private inner class.
     * @param attributeNameOfInnerClassInOuterClass This is the name of the attribute that is an inner class type, within the outer class.
     * @param innerClassName This is the class name of the inner class.
     * @param methodNameOfInnerClass This is the name of the method inside the inner class that should be called.
     * @return Returns the value returned by the method of the inner class. CAUTION: needs casting since its of type {@link Object}
     * 
     * @throws SecurityException 
     * @throws NoSuchFieldException 
     * @throws ClassNotFoundException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws Exception
     */
     public static <T extends Object> Object executeInnerClassMethod(T outerClassInstance, String attributeNameOfInnerClassInOuterClass, String innerClassName, String methodNameOfInnerClass) 
         throws NoSuchFieldException, SecurityException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
         IllegalArgumentException, InvocationTargetException {

         final Class<?> outerClass = outerClassInstance.getClass();

         final Field field = outerClass.getDeclaredField(attributeNameOfInnerClassInOuterClass);
         field.setAccessible(true);

         Class<?> innerClass = Class.forName(innerClassName);
         innerClass = field.getType();

         //access the method
         final Method method = innerClass.getDeclaredMethod(methodName, new Class<?>[]{});
         method.setAccessible(true);
         return method.invoke(field.get(outerClassInstance), EMPTY);
     }
}
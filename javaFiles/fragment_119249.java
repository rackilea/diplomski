@RunWith(PowerMockRunner.class)
public class A {
   @Test 
   public void testA() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
       ClassLoader classLoader = ClassLoader.getSystemClassLoader();
       Class<?> serviceClass = Class.forName(B.class.getName(), true, classLoader);
       Object serviceStub = serviceClass.newInstance();
       Method method = serviceClass.getMethod("fun");
       method.invoke(serviceStub);
   }
}
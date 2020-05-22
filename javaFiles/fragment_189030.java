java.lang.reflect.Method method;
try 
    {
      method = obj1.getClass().getMethod(methodname);
      method.invoke(obj1);
    } 
    catch (SecurityException e) 
    {}
    catch (NoSuchMethodException e)
    {}
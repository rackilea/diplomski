public void checkEnum(Field field, String setMethod, Class clazz) {
      try {
        String className = Character.toUpperCase(field.getName().charAt(0)) +
            field.getName().substring(1);
        Class<?> cls = Class.forName("com.citigroup.get.zcc.intf." + className);
        Object[] enumArray = cls.getEnumConstants();

        //set to the last Enum which is unknown
        invoke(setMethod, enumArray[enumArray.length - 1], clazz);
      } catch (Exception e) {
        System.out.println(e.toString());
      }
    }
    private Object invoke(String methodName, Object newValue, Class clazz) {
      Object value = null;
      try {
        MethodInvoker methodInvoker = new MethodInvoker(); // this was missing
        methodInvoker.setTargetMethod(methodName);
        methodInvoker.setTargetClass(clazz);  // This was missing

        if (newValue != null) {
          methodInvoker.setArguments(new Object[]{newValue});
        } else {
          methodInvoker.setArguments(new Object[]{});
        }
        methodInvoker.prepare();
        value = methodInvoker.invoke();
      } catch (ClassNotFoundException e) {
        throw new IllegalStateException("Method invocation failed. " + e.getMessage(), e);
      } catch (NoSuchMethodException e) {
        throw new IllegalStateException("Method invocation failed. " + e.getMessage(), e);
      } catch (java.lang.reflect.InvocationTargetException e) {
        throw new IllegalStateException("Method invocation failed. " + e.getMessage(), e);
      } catch (IllegalAccessException e) {
        throw new IllegalStateException("Method invocation failed. " + e.getMessage(), e);
      }

      return value;
    }
  }
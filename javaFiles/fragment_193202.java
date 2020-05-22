public void method(Object singleton) {
        Class<?> clazz = singleton.getClass();
        Method m;
        try {
            m = clazz.getDeclaredMethod("someCommonMethod");
            //m.setAccessible(true);
            m.invoke(singleton);
        } catch (Exception e) {
            e.printStackTrace();
        }
  }
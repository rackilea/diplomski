public static void asyncMethodInvoke(Class<?> clazz, String methodName, Object[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Class<?> params[] = new Class[args.length];
          for (int i = 0; i < params.length; i++) {
            if (args[i] instanceof Byte) {
              params[i] = Byte.TYPE;
            }
            else if(args[i] instanceof Short) {
              params[i] = Short.TYPE;
            }
            else if(args[i] instanceof Character) {
              params[i] = Character.TYPE;
            }
            else if(args[i] instanceof Integer) {
              params[i] = Integer.TYPE;
            }
            else if(args[i] instanceof Float) {
              params[i] = Float.TYPE;
            }
            else if(args[i] instanceof Double) {
              params[i] = Double.TYPE;
            }
            else if(args[i] instanceof Long) {
              params[i] = Long.TYPE;
            }
            else if(args[i] instanceof Boolean) {
              params[i] = Boolean.TYPE;
            }
            else {
              params[i] = args[i].getClass();
            }
          }

          Object _instance = clazz.newInstance();
          Method method = clazz.getDeclaredMethod(methodName, params);
          method.invoke(_instance, args);
        }
        catch (Exception e) {
          System.out.println(e.getCause().getMessage());
        }
      }
    }).start();
  }
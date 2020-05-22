private static void setEnv(Map<String, String> newEnv) throws Exception {
      Map<String, String> env = System.getenv();
      Class<?> cl = env.getClass();
      Field field = cl.getDeclaredField("m");
      field.setAccessible(true);
      @SuppressWarnings("unchecked")
      Map<String, String> envMap = (Map<String, String>) field.get(env);
      envMap.putAll(newEnv);
    }
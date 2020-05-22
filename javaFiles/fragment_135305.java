try {
   String msg = (String) this.getClass().getDeclaredMethod("pong", String.class).invoke(this, ss);
  } catch (IllegalAccessException e) {
   e.printStackTrace();
  } catch (InvocationTargetException e) {
   e.printStackTrace();
  } catch (NoSuchMethodException e) {
   e.printStackTrace();
  }
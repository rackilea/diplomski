try {
  Class rot = ROT.class;
  Method clear = rot.getDeclaredMethod("clearObjects", new Class[]{});
  clear.setAccessible(true);
  clear.invoke(null, new Object[]{});
} catch( Exception ex ) {
  ex.printStackTrace();
}
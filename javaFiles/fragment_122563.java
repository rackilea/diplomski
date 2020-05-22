Field f = getClass().getField(name);
if (f!=null){
 f.setAccessible(true);
 f.setInt(this, value);
}else
  throw new IllegalArgumentException("Invalid name: " + name);
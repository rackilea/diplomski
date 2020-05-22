int nonzeros = 0;
for (Field f : o.getClass().getDeclaredFields()) {
  f.setAccessible(true);
  if (f.getType().equals(Double.TYPE) && f.getDouble(o) != 0.0) {
    nonzeros++;
  }
}
for (Field f : getMaxRateCode.getClass().getDeclaredFields()) {
    f.setAccessible(true);
    Object o;
    try {
        o = f.get(getMaxRateCode);
    } catch (Exception e) {
        o = e;
    }
    System.out.println(f.getGenericType() + " " + f.getName() + " = " + o);
}
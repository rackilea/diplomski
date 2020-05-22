boolean isIndexed = false;
if (DosFileAttributes.class.isInstance(attr)) {
    isIndexed = true;
    try {
         Method m = attr.getClass().getDeclaredMethod("attributes");
         m.setAccessible(true);
         int attrs = (int) m.invoke(attr);
         isIndexed = ((attrs & 0x2000) == 0);
    } catch (Exception e) {
         // just gave it a try
    }
}
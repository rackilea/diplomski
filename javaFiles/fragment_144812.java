%pragma(java) moduleimports=%{
  import java.lang.reflect.Field;
%}

%pragma(java) modulecode=%{
  static Object getThisOrNull(final Object o, final Class c) {
    for (Field f: o.getClass().getDeclaredFields()) {
      if (f.getType().equals(c)) {
        try {
          return f.get(o);
        }
        catch (IllegalAccessException e) {
          // Omm nom nom...
        }
      }
    }
    return null;
  }
%}
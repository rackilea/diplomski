protected synchronized Class<?> loadClass(String name, boolean resolve)
throws ClassNotFoundException
{
    // First, check if the class has already been loaded
  Class c = findLoadedClass(name);
     if (c == null) {
        try {
            if (parent != null) {
              c = parent.loadClass(name, false);
             } else {
                c = findBootstrapClass0(name);
            }
        } catch (ClassNotFoundException e) {
            // If still not found, then invoke findClass in order
           // to find the class.
             c = findClass(name);
         }
     }
    if (resolve) {
       resolveClass(c);
     }
    return c;
}
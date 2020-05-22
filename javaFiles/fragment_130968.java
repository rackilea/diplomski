Class[] classes = /*...create and fill in the array...*/;
for (Class cls : classes) {
    // Look up the main method accepting an array of strings
    Method m = cls.getDeclaredMethod("main", String[].class);
    m.invoke(null, /*...see note below...*/);
}
String className = "com.your.package.Tab3";  // Change here
Object tab3 = null;
try {
    tab3 = Class.forName(className).newInstance();
} catch (InstantiationException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
return (Fragment) tab3;
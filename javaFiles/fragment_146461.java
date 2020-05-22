MyObject myObject = null;
for (Package p : Package.getPackages()) {
    try {
        myObject = Class.forName(p.getName() + "." + className).newInstance();
        break;
    } catch (ClassNotFoundException ex) {
        // ignore
    } 
}
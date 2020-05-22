for ( Object o : MyObj.all().fetch()) {
    // Check classloaders
    System.out.println(o.getClass().getClassLoader());
    System.out.println(MyObj.class.getClassLoader());
    break;
    //
    s = (MyObj) o;  // ClassCastException here

    if (!s.fileExists()) {
    //Do some stuff
    }
}
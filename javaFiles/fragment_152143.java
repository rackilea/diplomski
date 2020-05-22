Integer intVersion;
Number longVersion = 2332212344334L;

try{
    intVersion = (Integer) longVersion;
}
catch(ClassCastException e) {
    System.out.println("here is your notification :)");
}
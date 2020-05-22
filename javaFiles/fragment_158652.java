@BeforeClass
public static  void init(){ 
    System.setProperty( "com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
}

@AfterClass
public static void revert(){ 
    System.getProperties().remove("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize");
}
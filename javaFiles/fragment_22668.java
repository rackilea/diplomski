FileInputStream f1 = new FileInputStream("test1.xml");
FileInputStream f2 = new FileInputStream("test2.xml");
// Don't need to create the resources here, just need to declare some vars
try (InputStream in1 = f1; InputStream in2 = f2) {
    // error; in1 is final
    in1 = new FileInputStream("t");
}
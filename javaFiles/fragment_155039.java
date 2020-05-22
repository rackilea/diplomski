InputStream ddlStream = <SomeClassInsideTheSameJar>.class
    .getClassLoader().getResourceAsStream("some/pack/age/somelib.dll");

try (FileOutputStream fos = new FileOutputStream("somelib.dll");){
    byte[] buf = new byte[2048];
    int r;
    while(-1 != (r = ddlStream.read(buf))) {
        fos.write(buf, 0, r);
    }
}
String myDocuments = null;

try {
    Process p =  Runtime.getRuntime().exec("reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\" /v personal");
    p.waitFor();

    InputStream in = p.getInputStream();
    byte[] b = new byte[in.available()];
    in.read(b);
    in.close();

    myDocuments = new String(b);
    myDocuments = myDocuments.split("\\s\\s+")[4];

} catch(Throwable t) {
    t.printStackTrace();
}

System.out.println(myDocuments);
int arch = Integer.parseInt(System.getProperty("sun.arch.data.model"));
    InputStream is = null;
    if(arch==32)
        is = Logger.class.getClass().getResourceAsStream("/sigar-x86-winnt.dll");
    else if(arch==64)
        is = Logger.class.getClass().getResourceAsStream("/sigar-amd64-winnt.dll");

    Path sigar = Files.createTempFile("sigar_lib", ".dll");

    try (FileOutputStream out = new FileOutputStream(sigar.toFile())) 
            {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            } 
            catch (Exception e) {

        }
    System.load(sigar.toString());
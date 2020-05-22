public static boolean copyResource(ClassLoader classLoader, String resource_path, String resource, String destiny){
    FileOutputStream fos = null;
    Boolean retorno = false;
    try {
        InputStream is = classLoader.getResourceAsStream(resource_path + resource);

        if(is == null){
            System.out.println("Resource not found! >> " + resource_path + resource);
            retorno = false;
        }

        fos = new FileOutputStream( new File(destiny, resource));
        byte[] buffer = new byte[1024];
        int read = -1;
        while( (read = is.read(buffer)) != -1 ) {
            fos.write( buffer,0,read);
        }
        fos.flush();
        fos.close();
        retorno = true;
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if(fos != null)
                fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return retorno;
}
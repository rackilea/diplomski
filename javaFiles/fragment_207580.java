public static void copyFolder(File src, File dest) throws IOException{
    if (src.isDirectory()) {

        //if directory not exists, create it
        if(!dest.exists()){
            System.out.println("Creating directory " + dest);
            dest.mkdir();
            System.out.println("Created directory ");
        }

        for (String file : src.list()) {

            File srcFile = new File(src, file);
            File destFile = new File(dest, file);

            System.out.println("Copying " + srcFile + " to " + destFile);
            copyFolder(srcFile,destFile);
            System.out.println("Copied " + srcFile + " to " + destFile);
        }

    }else{

        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];

        System.out.println("Writing file " + src + " to " + dest);

        int length;
        //copy the file content in bytes
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }

        System.out.println("Closing file " + src);
        in.close();

        System.out.println("Closing file " + dest);
        out.close();

        System.out.println("Writing file " + src + " to " + dest + " is done");
    }
}
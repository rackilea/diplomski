OutputStream fos = null;
    try{
        fos = new FileOutputStream("RPGOutput.txt",true);
        PrintWriter out = new PrintWriter(fos, true);

        out.println("Someting");
        out.println("...");

        // 
        out.flush();
    }catch(IOException e){
        // Manage exception
    } finally {
        try{
            if(fos!=null){
                fos.close();
            }
        }catch(IOException e){
            // Swallow exception
        }
    }
try(OutputStream fos = new FileOutputStream("RPGOutput2.txt",true);
            PrintWriter out = new PrintWriter(fos,true);) {

        out.println("Hello");
        out.print("Hello 2");

    }  catch (IOException e) {
        // Manage exception
    }
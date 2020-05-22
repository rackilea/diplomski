try {
        java.io.PrintWriter output = new java.io.PrintWriter(file); 
        //rest of the code

    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
            }
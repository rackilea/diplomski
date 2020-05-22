try {
            desktop.browse(uri);
        } catch(IOException ioe) {
            System.out.println("The system cannot find the " + uri + " file specified");
            //ioe.printStackTrace();
        }
System.out.println("Creating Process"); 

        ProcessBuilder builder = new ProcessBuilder("my.py"); 
        Process pro = builder.start(); 

        // wait 10 seconds 
        System.out.println("Waiting"); 
        Thread.sleep(10000); 

        // kill the process 
        pro.destroy(); 
        System.out.println("Process destroyed");
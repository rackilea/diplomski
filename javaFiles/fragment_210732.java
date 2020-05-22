try
    {
        Process process = Runtime.getRuntime().exec(cmd);
        process.waitFor();
    }                               
    catch(IOException e)    
    {   
        //add logging functionality
        e.printStackTrace();
    }
    catch(InterruptedException e)    
    {   
        e.printStackTrace();
    }
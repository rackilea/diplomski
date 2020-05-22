private static boolean checkFinished(String path)
{
    boolean result = false;
    String directory = path + "\\expts";
    File dir = new File(directory);
    while(true) 
    {
        try 
        {
            Thread.sleep(3000);
        } catch (InterruptedException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(dir.isDirectory())
        {
            for(File f: dir.listFiles())
                if(!f.isDirectory() && "__COMPLETED__".equals(f.getName()))
                {
                    result = true;
                    logger.info(" SIMULATOR:  simulation finished ");
                     break;
                }
            if(result)
                break;
        }
    }
    return result;
}
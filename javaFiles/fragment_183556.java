public boolean saveSettings() 
{
    File f = new File(fsv.getHomeDirectory() + File.separator + "settings.cms");
    ObjectOutputStream objOut;
    try 
    {
        // Here was my problem. 
        detector.stopDetection();

        if(gui.saveSettings())
        {
            // Settings-file wegschrijven
            objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
            objOut.writeObject(settings);
            objOut.flush();
            objOut.close();
            return true;
        }
        else
        {
            return false;
        }
    } 
    catch (IOException e) 
    {
        handleExceptions(e);
        return false;
    }
}
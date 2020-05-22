class ClassB extends SwingWorker<Void, Integer>
{
    private File cfgFile;

    public ClassB(File cfgFile) {
       this.cfgFile = cfgFile;
    }

    protected Void doInBackground()
    {
        ClassC.runProgram(cfgFile);
    }

    protected void done()
    {
        try 
        { 
        tabs.setSelectedIndex(1);
        } 
        catch (Exception ignore) 
        {
           // *** ignoring exceptions is usually not a good idea. ***
        }
    }
}
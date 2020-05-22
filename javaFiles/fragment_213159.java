ObjectInputStream objetoInStr   = new ObjectInputStream(new FileInputStream(sPath))
{
    protected void readStreamHeader() throws IOException 
    {
    }
};
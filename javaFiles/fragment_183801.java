public synchronized static void stop() throws IOException{
    if(MashRocks.process != null)
    {
        MashRocks.process.destroy();
    }
}
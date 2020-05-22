public void printCpuUsages()
{
    try
    {
        RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
        String load = reader.readLine();
        while (load != null)
        {
            Log.d("CPU", "CPU usage: " + load);
            load = reader.readLine();
        }
    }
    catch (IOException ex)
    {
        ex.printStackTrace();
    }
}
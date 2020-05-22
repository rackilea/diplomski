ExecutorService exec = Executors.newFixedThreadPool(1);

// use RandomAccessFile because it supports readFully()
RandomAccessFile in = new RandomAccessFile("myfile.dat", "r");
in.seek(0L);

while (in.getFilePointer() < in.length())
{
    int readSize = (int)Math.min(1000000, in.length() - in.getFilePointer());
    final byte[] data = new byte[readSize];
    in.readFully(data);
    exec.execute(new Runnable() 
    {
        public void run() 
        {
            // do something with data
        }
    });
}
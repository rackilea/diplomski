@Override
public void run()
{
    try {
        Process proc=Runtime.getRuntime().exec(new String[]{
             "/bin/grep",
             "A"});
        OutputStream os=proc.getOutputStream();

        Thread t1=new Thread(new CopyTo(proc.getErrorStream(),System.err));
        Thread t2=new Thread(new CopyTo(proc.getInputStream(),System.out));
        t1.start();
        t2.start();
        int c;
        while((c=this.pipeInPipedInputStream.read())!=-1)
        {   
             os.write((char)c);
        }

        //missing lines of code
        os.flush();
        os.close();

        t1.join();
        t2.join();
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
}
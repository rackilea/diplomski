public class Estimator
{
    private static double R; // harmonic mean of all bandwidth measurements
    private static int n = 0; // number of measurements
    private static int skips = 5; // skip measurements for first 5 socket.read() operations

    // size in bytes
    // start/end in ns
    public static double harmonicMean(long start, long end, double size){
        // check if we need to skip this initial value, since it might falsify our estimate
        if(skips-- > 0) return 0;

        // get current value of R
        double curR = (size/(1024*1024))/(double)((end - start)*Math.pow(10, -9));
        System.out.println(curR);
        if(n == 0) {
            // initial value
            R = curR;
        } else {
            // use harmonic mean
            R = (n+1)/((n/R)+(1/curR));
        }

        n++;

        return R;
    }

    public static void main(String[] args)
    {
        // temporary buffer to hold bytes
        byte[] buffer = new byte[1024*1024*10]; // 10MB buffer - just in case ...

        Socket socket = null;
        try {
            // measurement done through file download from server
            // prepare request
            socket = new Socket("yourserver.com",80);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            InputStream is = socket.getInputStream();
            pw.println("GET /test_blob HTTP/1.1"); // a test file, e.g., 1MB big
            pw.println("Host: yourserver.com");
            pw.println("");
            pw.flush();

            // prepare measurement
            long start,end;
            double bytes = 0;
            double totalBytes = 0;
            start = System.nanoTime();
            while((bytes = is.read(buffer)) != -1) {
                // socket.read() occurred -> calculate harmonic mean
                end = System.nanoTime();
                totalBytes += bytes;
                harmonicMean(start, end, totalBytes);
            }

            // clean up
            is.close();
            pw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        finally {
            if(socket != null) {
                try{
                    socket.close();
                } 
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(R+" MB/s");
    }
}
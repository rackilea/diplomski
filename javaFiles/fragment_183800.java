public class MashRocks {

    protected static Process process = null;

    public static Process startThread(MashFormCnts mashFormCnts) throws IOException {
    ProcessBuilder pb = new ProcessBuilder("ffmpeg", "-i", "C:\\Users\\brett\\Documents\\Telegraph_Road.mp4", "C:\\Users\\brett\\Documents\\out.mp4");

    final Process p = pb.start();
    MashRocks.process = p;
    ....
    }
}
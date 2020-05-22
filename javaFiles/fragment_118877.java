import java.io.*;
public class Test2 {
    PipedOutputStream mHead;
    PipedInputStream mTail;
    byte[] mByteSlave = new byte[1024];
    boolean mStop;
    public static void main(String... ar) throws Exception {
        new Test2().run();
    }
    void run() throws Exception {
        mTail = new PipedInputStream();
        mHead = new PipedOutputStream(mTail);
        Thread mT1 = new Thread(new DecoderTask(), "Reader");
        Thread mT2 = new Thread(new WriteTask(), "Writer");
        mT1.start();
        mT2.start();
    }
    class DecoderTask implements Runnable {
        public void run() {
            while (!mStop) {
                try {
                    mHead.write(new byte[3000]);
                    mHead.flush();
                    System.out.println("decoded 3000");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class WriteTask implements Runnable {
        public void run() {
            while (!mStop) {
                try {
                    int len = mTail.read(mByteSlave, 0, mByteSlave.length);
                    if (len < 0) break; // EOF
                    // mAudioTrack.write(mByteSlave, 0, len);
                    // mAudioTrack.flush();
                    System.out.println("written " + len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
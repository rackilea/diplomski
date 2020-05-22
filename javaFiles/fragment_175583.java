import java.*;
import java.io.*;

class Main {

        public static void main(String[] args) throws IOException {

                Thread t = new Thread(new Runnable() {
                        public void run() {
                                int cnt = 0;

                                while (true) {
                                        System.out.println(cnt);
                                        ++cnt;
                                }
                        }
                });

                t.start();
                System.in.read();
                t.stop();
        }
}
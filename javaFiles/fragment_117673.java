public class P {

 public static void main(String[] args) {

 new Thread(new Runnable() {

        @Override
        public void run() {

            try {

            System.out.println("started");

                Clip clip = AudioSystem.getClip();

                File file = new File(".......................wav");

                AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);

                clip.open(inputStream);

                clip.start();

                while(clip.isOpen()) {
                  try { Thread.sleep(2000); } catch(InterruptedException ie) {}
                  if(!clip.isActive()) break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }).start();
 }

 }
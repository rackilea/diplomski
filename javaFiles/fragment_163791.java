public class Test {
    public static void main(String[] args) {
        final Object foo = new Object();
        Clip clip;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("go.wav")));
            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if(event.getType() == LineEvent.Type.STOP){
                        System.out.println("done playing");
                        synchronized(foo) {
                            foo.notify();
                        }

                    }
                }
            });
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized(foo) {
            try {
                foo.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
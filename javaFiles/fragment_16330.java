public class function {
    public static boolean playButton = true;
    public static void playMusic() {
            if (playButton == true) {
                System.out.println("Music"); 
            } else {
                System.out.println("No Music");
            }
    }
    public static void main(String[] args)
    {
       playMusic()
    }
}
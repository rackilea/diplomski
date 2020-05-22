public class PlayerThread implements Runnable{
    final BasicPlayer player;

    PlayerThread(String path){
        player = new BasicPlayer(new URL(path).openStream());
    }

    public void run(){
        player.player();
    }

    public void pause() {
        player.pause();
    }
}
public class Record implements Playable{
   public void play(){
       System.out.println("Playing Record");
   }
}

public class MP3 implements Playable{
   public void play(){
       System.out.println("Playing MP3");
   }
}
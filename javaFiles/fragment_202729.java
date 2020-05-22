public class Application{

    List<Playable> audioFiles = new ArrayList<Playable>();

    public static void main(String[] args){

        audioFiles.add(new Record());
        audioFiles.add(new MP3());

        for(Playable p: audioFiles){
            play(p);
        }
    }

    public static void play(Playable playable){
        playable.play();
    }
}
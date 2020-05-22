package andrewrubinfinalproject;

/**
 *
 * @author Andy
 */
public class AndrewRubinFinalProject {


   //fields to determine if the instrument is isTuned,
   private boolean isTuned;

   //and if the instrument is currently isPlaying.
   private boolean isPlaying;

   private String name;

   private int numberOfStrings = 4; // number of strings
   private String nameofStringsInInstrument[] = {"E", "C", "D", "A"}; //an array of string names


    //A constructor method that set the isTuned and currently isPlaying fields to false.

    public AndrewRubinFinalProject() {
        this.isTuned = false;
        this.isPlaying = false;
    }



    public String getNameOfInstrument() {
        return this.name;
    }


    public void setNameOfInstrument(String nameOfInstrument) {
        this.name = nameOfInstrument;
    }


    // Other methods

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public boolean isTuned() {
        return this.isTuned;
    }

    public void setTuned(boolean isTuned) {
        this.isTuned = isTuned;
    }

    public void startPlayInstrument() {
        System.out.println("The Instrument is now Playing.");
        this.isPlaying = true;
    }

    public void stopPlayInstrument() {
        System.out.println("The Instrument is not Playing anymore.");
        this.isPlaying = false;
    }

    public void startTuneInstrument() {
        System.out.println("The Instrument is Tuned.");
        this.isTuned = true;
    }

    public void stopTuneInstrument() {
        System.out.println("The Instrument is not Tuned.");
        this.isTuned = false;
    }  

    public int getNumberOfStrings() {
       return this.numberOfStrings ;
    }

    public String[] getStringNames() {
        return this.nameofStringsInInstrument;
    }

}
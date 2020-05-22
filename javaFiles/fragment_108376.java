//package recognitionprocess;
//import org.jaudiotagger.audio.*;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.sound.sampled.AudioFileFormat;

import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;

public class RecognitionMain {

    public static void main(String[] args)  {
        try{
        ambientListening();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void ambientListening() throws Exception{

        String filename = "tarunaudio.wav";//Your Desired FileName
        MicrophoneAnalyzer mic = new MicrophoneAnalyzer(AudioFileFormat.Type.WAVE);
       mic.open();
        mic.captureAudioToFile(filename);
        final int THRESHOLD = 10;//YOUR THRESHOLD VALUE.
        int ambientVolume = mic.getAudioVolume();//
        int speakingVolume = -2;
        boolean speaking = false;
            for(int i = 0; i<1||speaking; i++){
                int volume = mic.getAudioVolume();
                System.out.println(volume);
                if(volume>ambientVolume+THRESHOLD){
                    speakingVolume = volume;
                    speaking = true;
                    Thread.sleep(1000);
                    System.out.println("SPEAKING");
                }
                if(speaking && volume+THRESHOLD<speakingVolume){
                     break;
                }
                Thread.sleep(200);//Your refreshRate
            }
              mic.close();
            //You can also measure the volume across the entire file if you want
            //to be resource intensive.
            if(!speaking){
                 ambientListening();
            }
        Recognizer rec = new Recognizer(Recognizer.Languages.ENGLISH_US);
        GoogleResponse out = rec.getRecognizedDataForWave(filename);
        System.out.println(out.getResponse());
        ambientListening();
    }
}
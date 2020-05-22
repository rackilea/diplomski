/**
     * Copyright 2003 Sun Microsystems, Inc.
     * 
     * See the file "license.terms" for information on usage and
     * redistribution of this file, and for a DISCLAIMER OF ALL 
     * WARRANTIES.
     */
    import com.sun.speech.freetts.FreeTTS;
    import com.sun.speech.freetts.Voice;
    import com.sun.speech.freetts.VoiceManager;
    import com.sun.speech.freetts.audio.AudioPlayer;
    import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
    import javax.sound.sampled.AudioFileFormat.Type;

    /**
     * Simple program to demonstrate the use of the FreeTTS speech
     * synthesizer.  This simple program shows how to use FreeTTS
     * without requiring the Java Speech API (JSAPI).
     */
    public class FreeTTSHelloWorld {

        /**
         * Example of how to list all the known voices.
         */


        public static void main(String[] args) {

           // listAllVoices();

            FreeTTS freetts;
       AudioPlayer audioPlayer = null;
            String voiceName = "kevin16";

            System.out.println();
            System.out.println("Using voice: " + voiceName);

            /* The VoiceManager manages all the voices for FreeTTS.
             */
            VoiceManager voiceManager = VoiceManager.getInstance();
            Voice helloVoice = voiceManager.getVoice(voiceName);

            if (helloVoice == null) {
                System.err.println(
                    "Cannot find a voice named "
                    + voiceName + ".  Please specify a different voice.");
                System.exit(1);
            }

            /* Allocates the resources for the voice.
             */
            helloVoice.allocate();

            /* Synthesize speech.
             */
//create a audioplayer to dump the output file
           audioPlayer = new SingleFileAudioPlayer("C://output",Type.WAVE);
    //attach the audioplayer 
           helloVoice.setAudioPlayer(audioPlayer);



            helloVoice.speak("Thank you for giving me a voice. "
                             + "I'm so glad to say hello to this world.");



            /* Clean up and leave.
             */
            helloVoice.deallocate();
//don't forget to close the audioplayer otherwise file will not be saved
            audioPlayer.close();
            System.exit(0);
        }
    }
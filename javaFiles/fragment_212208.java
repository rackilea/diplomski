class Sound {
    protected String path;
    protected AudioFormat format;
    protected AudioInputStream sound2;
    protected SourceDataLine ausgabe;
    protected File soundfile;
    protected DataLine.Info data;
    protected byte buffer[]=new byte[1000000];
    protected boolean isplaying=false;
    protected boolean stop=false;
    protected int speed=5;
    protected int count=0;

    public Sound(String path2) {
        try {
        path=path2;
        soundfile=new File(path);
        sound2 = AudioSystem.getAudioInputStream(soundfile);
        format=sound2.getFormat();
        data=new DataLine.Info(SourceDataLine.class,format);
        ausgabe=(SourceDataLine) AudioSystem.getLine(data);
        buffer=new byte[1000000];
        } catch (Exception bug) {
            System.out.println(bug);
        }
    }
    public void reload(String path2) {
        try {
        path=path2;
        soundfile=new File(path);
        sound2 = AudioSystem.getAudioInputStream(soundfile);
        format=sound2.getFormat();
        data=new DataLine.Info(SourceDataLine.class,format);
        ausgabe=(SourceDataLine) AudioSystem.getLine(data);
        buffer=new byte[1000000];
        } catch (Exception bug) {
            System.out.println(bug);
        }
    }
    public void setspeed(int speedn) {
        speed=speedn;
    }
    public boolean isPlaying() {
        return isplaying;
    }
    public void stop() {
        stop=true;
    }
    public void play() {
        try {
        ausgabe.open(format);
        ausgabe.start();
        isplaying=true;
        stop=false;
        count=0;
        while ((count=sound2.read(buffer,0,buffer.length)) != -1) {
            if (stop==true) {
                break;
            }
            /*try {
            Thread.sleep(speed);
            } catch(InterruptedException bug) {
            Thread.currentThread().interrupt();
            System.out.println(bug);
            }*/
            if (count > 0) {
                ausgabe.write(buffer, 0, count);
            } 
        }
        count=0;
        ausgabe.drain();
        ausgabe.close();
        isplaying=false;
        } catch (LineUnavailableException bug) {
            System.out.println(bug);
        } catch (IOException bug) {
            System.out.println(bug);
        }
    }
}

class Recorder {
    protected String type;
    protected AudioFileFormat.Type soundtype;
    protected AudioFormat format;
    protected TargetDataLine eingabe;
    protected File writefile;
    protected DataLine.Info data;
    protected boolean isrecording=false;
    protected boolean stop=false;

    public Recorder(String pathn,String typen) {
        try {
        writefile=new File(pathn);
        format=new AudioFormat(44100.0F,16,1,true,false);
        data=new DataLine.Info(TargetDataLine.class,format);
        if (typen=="AIFC") {
            soundtype = AudioFileFormat.Type.AIFC;
        }
        if (typen=="AIFF") {
            soundtype = AudioFileFormat.Type.AIFF;
        }
        if (typen=="WAVE") {
            soundtype = AudioFileFormat.Type.WAVE;
        }
        if (typen=="AU") {
            soundtype = AudioFileFormat.Type.AU;
        }
        if (typen=="SND") {
            soundtype = AudioFileFormat.Type.SND;
        }
        eingabe=(TargetDataLine) AudioSystem.getLine(data);
        } catch (Exception bug) {
            System.out.println(bug);
        }
    }
    public void format(float rate, int bits,int channels, boolean signed, boolean endian) {
        format=new AudioFormat(rate,bits,channels,signed,endian);
    }
    public void settype(String typen) {
        if (typen=="AIFC") {
            soundtype = AudioFileFormat.Type.AIFC;
        }
        if (typen=="AIFF") {
            soundtype = AudioFileFormat.Type.AIFF;
        }
        if (typen=="WAVE") {
            soundtype = AudioFileFormat.Type.WAVE;
        }
        if (typen=="AU") {
            soundtype = AudioFileFormat.Type.AU;
        }
        if (typen=="SND") {
            soundtype = AudioFileFormat.Type.SND;
        }
    }
    public void setname(String pathn) {
        writefile = new File(pathn);
    }
    public boolean isRecording() {
        return isrecording;
    }
    public void stop() {
        try {
        isrecording=false;
        eingabe.stop();
        eingabe.close();
        } catch (Exception bug){
            System.out.println(bug);
        }
    }
    public void record() {
        try {
            isrecording=true;
            eingabe.open(format);
            eingabe.start();
            AudioSystem.write(new AudioInputStream(eingabe),soundtype,writefile);
        } catch (Exception bug){
            System.out.println(bug);
        }
    }
}

class Arrayhelper {
    public Arrayhelper() {
    }
    public int[][] append(int[][] array,int[] element) {
         int[][] rarray = new int[array.length+1][];
         for (int iter7=0;iter7 < array.length;iter7=iter7+1) {
             rarray[iter7]=array[iter7];     
         }
         rarray[array.length]=element;
         return rarray;
    }
    public int[][] remove(int[][] array,int iterator) {
         try {
         int[][] rarray = new int[array.length-1][];

         int rarray_iter=-1;
         for (int iter8=0;iter8 < array.length;iter8=iter8+1) {
             rarray_iter=rarray_iter+1;
             if (iter8==iterator) {
                 rarray_iter=rarray_iter-1;
             }
             else {
                 rarray[rarray_iter]=array[iter8];
             }     
         }
         rarray_iter=0;
         return rarray;
         }
         catch (java.lang.IndexOutOfBoundsException bug) {
         System.out.println(bug);
         System.out.println(Arrays.toString(array));
         return array;
         }
    }
}
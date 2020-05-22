public class NoiseRecorder 
{

private final String TAG = SoundOfTheCityConstants.TAG;
public static double REFERENCE = 0.00002;

public double getNoiseLevel() throws NoValidNoiseLevelException
{
    Logging.e(TAG, "start new recording process");
    int bufferSize = AudioRecord.getMinBufferSize(44100,AudioFormat.CHANNEL_IN_DEFAULT,AudioFormat.ENCODING_PCM_16BIT);
    //making the buffer bigger....
    bufferSize=bufferSize*4;
    AudioRecord recorder = new AudioRecord(MediaRecorder.AudioSource.MIC,
            44100, AudioFormat.CHANNEL_IN_DEFAULT, AudioFormat.ENCODING_PCM_16BIT, bufferSize);

    short data [] = new short[bufferSize];
    double average = 0.0;
    recorder.startRecording();
    //recording data;
    recorder.read(data, 0, bufferSize);

    recorder.stop();
    Logging.e(TAG, "stop");
    for (short s : data)
    {
        if(s>0)
        {
            average += Math.abs(s);
        }
        else
        {
            bufferSize--;
        }
    }
    //x=max;
    double x = average/bufferSize;
    Logging.e(TAG, ""+x);
    recorder.release();
    Logging.d(TAG, "getNoiseLevel() ");
    double db=0;
    if (x==0){
        NoValidNoiseLevelException e = new NoValidNoiseLevelException(x);
        throw e;
    }
    // calculating the pascal pressure based on the idea that the max amplitude (between 0 and 32767) is 
    // relative to the pressure
    double pressure = x/51805.5336; //the value 51805.5336 can be derived from asuming that x=32767=0.6325 Pa and x=1 = 0.00002 Pa (the reference value)
    Logging.d(TAG, "x="+pressure +" Pa");
    db = (20 * Math.log10(pressure/REFERENCE));
    Logging.d(TAG, "db="+db);
    if(db>0)
    {
        return db;
    }
    NoValidNoiseLevelException e = new NoValidNoiseLevelException(x);
    throw e;
}
}
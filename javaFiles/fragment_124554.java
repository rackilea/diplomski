package com.example.revertback;

public class AudioDispatcherFactory {


public static AudioDispatcher fromDefaultMicrophone(final AudioRecord audioInputStream,final int sampleRate,
                                                    final int audioBufferSize, final int bufferOverlap) {
    int minAudioBufferSize = AudioRecord.getMinBufferSize(sampleRate,
            android.media.AudioFormat.CHANNEL_IN_MONO,
            android.media.AudioFormat.ENCODING_PCM_16BIT);
    int minAudioBufferSizeInSamples =  minAudioBufferSize/2;
    if(minAudioBufferSizeInSamples <= audioBufferSize ){

        TarsosDSPAudioFormat format = new TarsosDSPAudioFormat(sampleRate, 16,1, true, false);

        TarsosDSPAudioInputStream audioStream = new AndroidAudioInputStream(audioInputStream, format);
        //start recording ! Opens the stream.
        return new AudioDispatcher(audioStream,audioBufferSize,bufferOverlap);
    }else{
        throw new IllegalArgumentException("Buffer size too small should be at least " + (minAudioBufferSize *2));
    }
}



public static AudioDispatcher fromPipe(final String source,final int targetSampleRate, final int audioBufferSize,final int bufferOverlap){
    PipedAudioStream f = new PipedAudioStream(source);
    TarsosDSPAudioInputStream audioStream = f.getMonoStream(targetSampleRate,0);
    return new AudioDispatcher(audioStream, audioBufferSize, bufferOverlap);
}
}
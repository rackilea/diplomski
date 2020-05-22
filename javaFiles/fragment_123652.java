public class AACPlayer extends AbstractPlayer implements Runnable {
private Thread runnerThread;
@Override
public void stop() {
    stop = true;
    GUIHandler.getInstance().resetComponents();
}

@Override
public void play() {
    stop = false;
    if(!runnerThread.isAlive()) {
        runnerThread = new Thread(this);
        runnerThread.start();
    }
}

@Override
public void setUrl(URL url) {
    this.url = url;
}

@Override
public void run() {
    decodeAndPlayAAC();
}

private void decodeAndPlayAAC() {
    SourceDataLine line = null;
    byte[] b;
    try {
        isPlaying = true;
        final ADTSDemultiplexer adts = new ADTSDemultiplexer(url.openStream());
        final Decoder dec = new Decoder(adts.getDecoderSpecificInfo());
        final SampleBuffer buf = new SampleBuffer();
        while(!stop) {
            b = adts.readNextFrame();
            dec.decodeFrame(b, buf);

            if(line==null) {
                final AudioFormat aufmt = new AudioFormat(buf.getSampleRate(), buf.getBitsPerSample(), buf.getChannels(), true, true);
                line = AudioSystem.getSourceDataLine(aufmt);
                line.open();
                line.start();
            }
            b = buf.getData();
            line.write(b, 0, b.length);
        }
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    } catch (AACException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(line!=null) {
            line.stop();
            line.close();
            isPlaying = false;
        }
    }
}
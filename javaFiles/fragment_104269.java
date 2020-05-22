public class SineAudioSource implements SimpleAudioClient.Processor {

    private final static int TABLE_SIZE = 200;
    private int left_phase = 0;
    private int right_phase = 0;
    private float[] data;

    public void setup(float samplerate, int buffersize) {
        data = new float[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            data[i] = (float) (0.2 * Math.sin(((double) i / (double) TABLE_SIZE) * Math.PI * 2.0));
        }
    }

    public void process(int channelNumber, FloatBuffer[] inputs, FloatBuffer[] outputs) {

        FloatBuffer left = outputs[channelNumber];
        int size = left.capacity();
        for (int i = 0; i < size; i++) {
            left.put(i, data[left_phase]);
            left_phase += 2;
            right_phase += 3;
            if (left_phase >= TABLE_SIZE) {
                left_phase -= TABLE_SIZE;
            }
        }
    }

    public void shutdown() {
        System.out.println("Sine Audio Source shutdown");
    }
}
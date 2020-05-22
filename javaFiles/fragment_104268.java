public class SimpleAudioClient {

    private boolean autoconnect = true;
    private JackClient client;
    private Processor processor;
    private Callback callback;
    private ShutDownHook shutDownHook;
    private JackPort[] inputPorts;
    private JackPort[] outputPorts;
    private FloatBuffer[] inputBuffers;
    private FloatBuffer[] outputBuffers;
    private float samplerate;
    private int buffersize;
    private volatile boolean active;

    private Logger logger = Logger.getLogger(getClass().getSimpleName());
    private int channelNumber = 0;

    public SimpleAudioClient() throws JackException {

        Jack jack = Jack.getInstance();
        logger.debug("Jack instance " + jack.toString());
        EnumSet<JackOptions> options = EnumSet.of(JackOptions.JackNoStartServer);
        EnumSet<JackStatus> status = EnumSet.noneOf(JackStatus.class);
        try {
            client = jack.openClient("jna_jack", options, status);
        } catch (JackException ex) {
            System.out.println("ERROR : Status : " + status);
            throw ex;
        }

        String[] inputs = new String[0];
        inputPorts = new JackPort[inputs.length];
        EnumSet<JackPortFlags> flags = EnumSet.of(JackPortFlags.JackPortIsInput);
        for (int i = 0; i < inputs.length; i++) {
            //inputPorts[i] = client.registerPort(inputs[i], JackPortType.AUDIO, flags);
        }

        String[] outputs = new String[]{"playback_1", "playback_2", "playback_3", "playback_4", "playback_5", "playback_6", "playback_7", "playback_8"};
        outputPorts = new JackPort[outputs.length];
        flags = EnumSet.of(JackPortFlags.JackPortIsOutput);
        for (int i = 0; i < outputs.length; i++) {
            outputPorts[i] = client.registerPort(outputs[i], JackPortType.AUDIO, flags);
        }

        processor = new SineAudioSource();

        this.inputBuffers = new FloatBuffer[inputPorts.length];
        this.outputBuffers = new FloatBuffer[outputPorts.length];
        this.callback = new Callback();
        this.shutDownHook = new ShutDownHook();
        client.onShutdown(shutDownHook);

        for (JackPort port : inputPorts) {
            logger.debug("input port " + port.getType() + " " + port.getName());
        }

        for (JackPort port : outputPorts) {
            logger.debug("output port " + port.getType() + " " + port.getName());
        }
    }

    public void activate(int channelNr) throws JackException {

        this.channelNumber = channelNr;

        try {
            samplerate = client.getSampleRate();
            System.out.println("Sample rate = " + samplerate);
            buffersize = client.getBufferSize();
            System.out.println("Buffersize = " + buffersize);
            processor.setup(samplerate, buffersize);
            active = true;
            client.setProcessCallback(callback);
            client.activate();
            if (autoconnect) {
                doAutoconnect();
            }
        } catch (Exception ex) {
            active = false;
            throw new JackException("Could not activate Jack client");
        }
    }

    private void doAutoconnect() throws JackException {
        Jack jack = Jack.getInstance();
        String[] physical = jack.getPorts(client, null, JackPortType.AUDIO,
                EnumSet.of(JackPortFlags.JackPortIsInput, JackPortFlags.JackPortIsPhysical));
        int count = Math.min(outputPorts.length, physical.length);
        for (int i = 0; i < count; i++) {
            logger.debug("output port " + outputPorts[i].getName());
            jack.connect(client, outputPorts[i].getName(), physical[i]);
        }
        physical = jack.getPorts(client, null, JackPortType.AUDIO,
                EnumSet.of(JackPortFlags.JackPortIsOutput, JackPortFlags.JackPortIsPhysical));
        count = Math.min(inputPorts.length, physical.length);
        for (int i = 0; i < count; i++) {
            logger.debug("input port " + inputPorts[i].getName());
            //jack.connect(client, physical[i], inputPorts[i].getName());
        }
    }

    public void shutdown() {
        active = false;
        client.deactivate();
        client.close();
    }

    private void processBuffers(int nframes) {
        for (int i = 0; i < inputPorts.length; i++) {
            inputBuffers[i] = inputPorts[i].getFloatBuffer();
        }
        for (int i = 0; i < outputPorts.length; i++) {
            outputBuffers[i] = outputPorts[i].getFloatBuffer();
        }
        processor.process(channelNumber, inputBuffers, outputBuffers);
    }

    private class Callback implements JackProcessCallback {

        public boolean process(JackClient client,final int nframes) {

            if (!active) {
                return false;
            } else {
                try {
                    processBuffers(nframes);
                    return true;
                } catch (Exception ex) {
                    System.out.println("ERROR : " + ex);
                    active = false;
                    return false;
                }

            }
        }
    }

    private class ShutDownHook implements JackShutdownCallback {

        public void clientShutdown(JackClient client) {
            active = false;
            processor.shutdown();
        }
    }

    public static interface Processor {

        public void setup(float samplerate, int buffersize);

        public void process(int channelNumber, FloatBuffer[] inputs, FloatBuffer[] outputs);

        public void shutdown();
    }

    /**
     * Create a SimpleAudioClient.
     *
     * @return client
     * @throws org.jaudiolibs.jnajack.JackException
     */
    public static SimpleAudioClient create(
    ) throws JackException {

        return new SimpleAudioClient();
    }
}
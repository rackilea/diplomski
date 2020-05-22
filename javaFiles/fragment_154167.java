public class JmeterOutListener extends AbstractListenerElement implements SampleListener,Clearable,Serializable,TestListener,Remoteable,NoThreadClone{

    public JmeterOutListener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void testEnded() {
        // TODO Auto-generated method stub
    }

    @Override
    public void testEnded(String arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void testStarted() {
        // TODO Auto-generated method stub
    }

    @Override
    public void testStarted(String arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void testIterationStart(LoopIterationEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void clearData() {
        // TODO Auto-generated method stub
    }

    @Override
    public void sampleOccurred(SampleEvent event) {

        SampleResult sample = event.getResult();

        System.out.println("sampleOccurred().sample.getTimeStamp() : " + sample.getTimeStamp());
        System.out.println("sampleOccurred().sample.getTime() : " + sample.getTime());
        System.out.println("sampleOccurred().sample.getSampleLabel() : " + sample.getSampleLabel());
        System.out.println("sampleOccurred().sample.getResponseCode() : " + sample.getResponseCode());
        System.out.println("sampleOccurred().sample.getResponseMessage() : " + sample.getResponseMessage());
        System.out.println("sampleOccurred().sample.getThreadName() : " + sample.getThreadName());
        System.out.println("sampleOccurred().sample.isSuccessful() : " + sample.isSuccessful());

        String              message             = null;
        AssertionResult[]   results             = sample.getAssertionResults();
        if (results != null)
        {
            for (int i = 0; i < results.length; ++i) {
                message = results[i].getFailureMessage();
                System.out.println("sampleOccurred().message : " + message);
                if (message != null) {
                    break;
                }
            }
        }

        System.out.println("sampleOccurred().sample.getBytes() : " + sample.getBytes());
        System.out.println("sampleOccurred().sample.getGroupThreads() : " + sample.getGroupThreads());
        System.out.println("sampleOccurred().sample.getAllThreads() : " + sample.getAllThreads());
        System.out.println("sampleOccurred().sample.getURL() : " + sample.getURL());
        System.out.println("sampleOccurred().sample.getLatency() : " + sample.getLatency());
        System.out.println("sampleOccurred().sample.getDataEncodingWithDefault() : " + sample.getDataEncodingWithDefault());
        System.out.println("sampleOccurred().sample.getSampleCount() : " + sample.getSampleCount());
        System.out.println("sampleOccurred().sample.getErrorCount() : " + sample.getErrorCount());

    }

    @Override
    public void sampleStarted(SampleEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void sampleStopped(SampleEvent arg0) {
        // TODO Auto-generated method stub
    }

}
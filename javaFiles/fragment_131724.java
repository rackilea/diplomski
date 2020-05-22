public class SaveAdMessageDrivenBean implements MessageListener {

    @Inject  
    private AnalyzerResultSaver saver;

    @Resource
    private MessageDrivenContext mdc;

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage obj = (ObjectMessage)message;
                AnalyzerResult alyzres = (AnalyzerResult)obj.getObject();
                saver.save(alyzres);
            }
        } catch (Throwable e) { 
            mdc.setRollbackOnly();
            log.log(Level.SEVERE, e);
        }
    }
}
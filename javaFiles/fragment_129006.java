private static final Logger DATA_LOG = Logger.getLogger("TestLog");
private static final Logger LOG = Logger.getLogger(Test.class);

public static final void main(String[] args){
    LOG.error("MSG1");
    DATA_LOG.error("MSG2");
}
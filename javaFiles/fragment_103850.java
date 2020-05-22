private static final Logger LOG = Logger.getLogger(MyTestClass.class.getName());

@Override
public void do(String u, String p) throws IOException {
    LOG.log(Level.INFO, "output1: "+ u);
    LOG.log(Level.INFO, "output2: "+ p);
    LOG.log(Level.INFO, "output3");
}
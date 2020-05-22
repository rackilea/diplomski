public class RssHandler {
    private static final Logger theLogger = LoggerFactory.getLogger(RssHandler.class);

    public void printRss(Message m) { // The Message Object is in the spring integration packages or in the spring core packages depending on the version
        System.out.println(m);
    }

}
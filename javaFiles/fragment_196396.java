public class ProcessSVN implements Runnable {

    private String url;

    public ProcessSVN(String url) {
        this.url = url;
    }

    public void run() {
        SVNRepository repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
        // do stuff with repository
    }
}
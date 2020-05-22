public class Request implements Callable<InputStream> {

    private String url;

    public Request(String url) {
        this.url = url;
    }

    @Override
    public InputStream call() throws Exception {
        return new URL(url).openStream();
    }

}
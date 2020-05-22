public class IpRange {
    private String ipMain = "10.0.0.";
    private int startRange = 2; // 2 = 10.0.0.2
    private int endRange = 5;   // 5 = 10.0.0.5
    private int ipRangeLength = endRange - startRange;
    private String urlParam = ":8098/?cmd=nothing";

    public static void main(String[] args) {

        IpRange ipRange = new IpRange();

        // true -> ip range url with parameters / false -> only ip range
        String[] results = ipRange.ipRangeGenerator(true);

        for (String output : results)
            System.out.println(output);

    }

    public String[] ipRangeGenerator(boolean link) {
        String[] ipAddresses = new String[ipRangeLength];
        String urlRange;

        for (int i = 0; i < ipRangeLength; i++) {
            String ipRange = ipMain + (startRange + i);
            urlRange = ipRange;
            if (link)
                urlRange = "http://" + ipRange + urlParam;
            ipAddresses[i] = urlRange;
        }
        return ipAddresses;
    }

}
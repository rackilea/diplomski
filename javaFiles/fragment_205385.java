public class IpRange {
    private static String ipMain = "10.0.0.";
    private static int minIpRange = 2;
    private static int maxIpRange = 255;
    private static String[] ipAddresses = new String[maxIpRange];

    public static void main(String[] args) {
        for (int i = minIpRange; i < maxIpRange; i++) {
            String ipRange = ipMain + i;
            //IP range in Array
            ipAddresses[i] = ipRange;

            //if you need full IP range in Url, then unmark the following 2 lines and mark above line
            //String urlRange = "http://" + ipRange + ":8098/?cmd=nothing";
            //ipAddresses[i] = urlRange;
        }

        //testing array results
        for (int i = minIpRange; i < maxIpRange; i++)
            System.out.println(ipAddresses[i]);
    }
}
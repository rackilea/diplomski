import org.apache.commons.net.whois.*;

public class Main {
    public static void main(String[] args) {
        WhoisClient whois = new WhoisClient();
        String whoishost = "whois.jprs.jp";
       // String whoishost = "whois.verisign-grs.com"; // for .com domains
        String domain = "ac.jp";
        try {
            whois.connect(whoishost);
            String whoisData = whois.query(domain);
            if (whoisData.toUpperCase().contains("NO MATCH")){
                System.out.println("Domain is not registered. According to whoishost: " + whoishost);
            }
            else{
                System.out.println("Domain is registered. According to whoishost: " + whoishost);
            }
        } catch (java.io.IOException ioex) {
            System.out.println("failed");
        }
    }
}
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    private static final Pattern PATTERN = Pattern.compile("bytes\\s+from\\s+([\\d,\\.]+):");

    public static void main(String args[]) {
        String input = "[1463895254]PING www.andi.dz (213.179.181.44) 100(128) bytes of data.[1463895254]108 bytes from 213.179.181.44: icmp_seq=1 ttl=54 time=195 ms[1463895255]108 bytes from 213.179.181.44: icmp_seq=2 ttl=54 time=202 ms[1463895256]108 bytes from 213.179.181.44: icmp_seq=3 ttl=54 time=180 ms[1463895257]108 bytes from 213.179.181.44: icmp_seq=4 ttl=54 time=200 ms[1463895258]108 bytes from 213.179.181.44: icmp_seq=5 ttl=54 time=206 ms[1463895259]108 bytes from 213.179.181.44: icmp_seq=6 ttl=54 time=188 ms[1463895260]108 bytes from 213.179.181.44: icmp_seq=7 ttl=54 time=182 ms[1463895261]108 bytes from 213.179.181.44: icmp_seq=8 ttl=54 time=223 ms[1463895263]108 bytes from 213.179.181.44: icmp_seq=9 ttl=54 time=187 ms[1463895263]108 bytes from 213.179.181.44: icmp_seq=10 ttl=54 time=199 ms";

        List<String> op = parseIndividualIP(input);
        op.forEach(System.out::println);
    }

    public static List<String> parseIndividualIP(String input) {
        Matcher m = PATTERN.matcher(input);
        List<String> ips = new LinkedList<>();
        while (m.find()) {
            ips.add(m.group(1));
        }
        return ips;
    }
}
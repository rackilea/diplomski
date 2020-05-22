// Assuming IPv4, and the inputs are valid (start before end) 
// and no overlapping ranges. 
public class CountyCodeToIPMap {
    private final TreeMap<Long, CountryCodeEntry> ipMap = 
            new TreeMap<Long, CountryCodeEntry>();

    public void addIpRange(long startIp, long endIp, String countryCode) {
        ipMap.put(startIp, new CountryCodeEntry(endIp, countryCode);
    }

    public String getCountryCode(long ip) {
        Map.Entry<Long, CountryCodeEntry> entry = ipMap.floorEntry(ip);
        if (entry != null && ip <= entry.getValue().endIpAddress) {
            return entry.getValue().countryCode;
        } else {
            return null;
        }
    }
}

public class CountryCodeEntry {
    public final long endIpAddress;
    public final String countryCode;
    public CountryCodeEntry (long endIpAddress, String countryCode) {
        this.endIpAddress = endIpAdddress;
        this.countryCode = countryCode;
    }
}
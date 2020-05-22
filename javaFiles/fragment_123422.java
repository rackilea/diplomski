public enum Region {
    CALIFORNIA, HAWAII, LOUISIANA
}

public class RegionData {
    public final Region region;
    public final String url;
    public final int population;
    public RegionData(Region region, String url, int population) {
        this.region = region;
        this.url = url;
        this.popuplation = population;
    }
}

…

Map<Region, RegionData> regionData = new HashMap<Region, RegionData>();
regionData.put(Region.CALIFORNIA, new RegionData(Region.CALIFORNIA, "http://http://california.gov/", 10123321));
…

System.out.println(regionData.get(Region.CALIFORNIA).url);
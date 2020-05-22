public class TimeZone{

    public static void main(String[] args) {

        TreeSet<String> sz= new TreeSet<>(ZoneId.getAvailableZoneIds());

        System.out.println("Number of zones: " + sz.size());
        System.out.println("");

        for (String zone : sz) {
            System.out.println(zone);
        }
    }
}
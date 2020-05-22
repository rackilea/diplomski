public class TestClock {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Asia/Beirut");
        ZonedDateTime zdt = ZonedDateTime.now(zone);
        System.out.println(zdt);
    }
}
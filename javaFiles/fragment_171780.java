public class EnumTest {
EnumDay day;

public EnumTest(EnumDay day) {
    this.day = day;
}

public void tellItLikeItIs() {
    switch (day) {
    case MONDAY:
        System.out.println("Mondays are bad.");
        break;

    case FRIDAY:
        System.out.println("Fridays are better.");
        break;

    case SATURDAY:
    case SUNDAY:
        System.out.println("Weekends are best.");
        break;

    case NAVEED:
        System.out.println(day + " is best.");
        break;

    default:
        System.out.println("Midweek days are so-so.");
        break;
    }
}

public static void main(String[] args) {
    EnumTest firstDay = new EnumTest(EnumDay.MONDAY);
    firstDay.tellItLikeItIs();
    EnumTest thirdDay = new EnumTest(EnumDay.WEDNESDAY);
    thirdDay.tellItLikeItIs();
    EnumTest fifthDay = new EnumTest(EnumDay.FRIDAY);
    fifthDay.tellItLikeItIs();
    EnumTest sixthDay = new EnumTest(EnumDay.SATURDAY);
    sixthDay.tellItLikeItIs();
    EnumTest seventhDay = new EnumTest(EnumDay.SUNDAY);
    seventhDay.tellItLikeItIs();
    EnumTest eigththDay = new EnumTest(EnumDay.NAVEED);
    eigththDay.tellItLikeItIs();
}
}
public static void main(String[] args) {
    try {
        TimePart d1 = TimePart.parse("00:1:9:14");
        TimePart d2 = TimePart.parse("00:3:10:4");
        TimePart d3 = TimePart.parse("00:3:39:49");
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        TimePart d4 = d1.add(d2).add(d3);
        System.out.println(d4);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
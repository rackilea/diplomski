public static void main(String[] args) {
    String str = "83.320869,17.735924,83.322868,17.737820,83.323715,17.738564";
    List<String> list = Arrays.asList(str.split(",")); // split-ing the string
    Iterator<String> i = list.iterator();
    double lat = 0, lon = 0;
    while (i.hasNext()) {
        lat = Double.parseDouble(i.next());
        lon = Double.parseDouble(i.next());
        System.out.println("lat=" + lat + ", long=" + lon);
    }

}
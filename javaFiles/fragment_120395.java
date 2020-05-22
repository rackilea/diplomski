hrrrLabels = new String[24];
final LinkedList<String> rawHours = new LinkedList<>();
final StringBuilder builder = new StringBuilder();

try {
    Document doc =
            Jsoup.connect("http://mag.ncep.noaa.gov/model-guidance-model-parameter.php?group=Model%20Guidance&model=HRRR&area=CONUS&ps=model").get();

    Elements links = doc.select("tr");
    int superi = 0;
    for (int i = 22; i < 26; i++) {
        Element link = links.get(i);
        Elements lin = link.select("td");
        Element time;

        for (int j = 0; j < lin.size(); j++) {
            time = lin.get(j);
            rawHours.add(time.text());
            builder.append(time.text() + "\n");

        }
        superi++;
    }
} catch (IOException e) {
    builder.append("Error :      ").append(e.getMessage()).append("\n");
}

for (int i = rawHours.size() - 1; i >= 0; i--) {
    hrrrLabels[23 - i] = rawHours.get(i);
}
String[] SplitTime;
String[] hrrrTimes = new String[hrrrLabels.length];
System.out.println("rewtimes, length=" + hrrrLabels.length);
for (int i = 0; i < hrrrLabels.length; i++) {
    System.out.println("rewtimes, i=" + i + " :" + hrrrTimes[i]);
    SplitTime = hrrrLabels[i].split(" ");
    hrrrTimes[i] = SplitTime[1].substring(0, 2);
}
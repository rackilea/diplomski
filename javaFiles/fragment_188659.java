String timeString = "01:00:100";
int multiplier[] = {3600000, 60000, 100};
String splits[] = timeString.split(":");
long time = 0;
for (int x = 0; x < splits.length; x++) {
    time += (Integer.parseInt(splits[x]) * multiplier[x]);
}
System.out.println(time);
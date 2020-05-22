public static final String beginning = "#EXTINF:";
public static final String afterNumber = ",";

public static int getTotalMinutes(String playList) {
    int value = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader(new File(playList)));
        String s;
        while ((s = br.readLine()) != null) // if "s" first line is not null
        {
            if (s.contains(beginning)) {
                String numberInString = s.substring(beginning.length(), s.indexOf(afterNumber));
                value += Integer.valueOf(numberInString);
            }
        }
        br.close();
    } catch (Exception e) {
    }
    return value;
}
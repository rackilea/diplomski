import java.util.Map;
import java.util.HashMap;

private static Map<Integer, int[]> years = new HashMap<>();
private static String[] monthNames = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

static {
    for(int year = 16; year <= 18; year++) {
        years.put(year, new int[12]);
    }
}

public static void months(String dates) { // method names should start with lower case
    int year = Integer.parseInt(dates.substring(2, 4));
    int month = Integer.parseInt(dates.substring(5, 7)) - 1; // date String is one-based, array-index is zero-based
    years.get(year)[month]++;
}

public static void print() {
    for(int year = 16; year <= 18; year++) {
        int[] monthCounts = years.get(year);
        for(int month = 0; month < 12; month++) {
            System.out.println(monthNames[month] + " " + year + ": " + monthCounts[month]);
        }
    }
}
static int[] series = new int[100];
static int seriesLength = 0;
...
// Get the input for range

public static void showSeries(int range)
{
    seriesLength = range;
    series = new int[seriesLength];
    for (int i = 0; i < series.legnth; i++) {
        series[i] = i;
        System.out.print(series[i] + " ");
    }
}
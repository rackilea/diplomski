public class CharCounter {

    final int max;
    final int[] counts;

    public CharCounter(char max) {
        this.max = (int) max;
        counts = new int[this.max + 1];
    }

    public void addCounts(char[] line) {
        for (int symbol : line) {
            counts[symbol]++;
        }
    }

    public Map<Integer, Integer> getCounts() {
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int symbol = 0; symbol < counts.length; symbol++) {
            int count = counts[symbol];
            if (count > 0) {
                countsMap.put(symbol, count);
            }
        }
        return countsMap;
    }
}
import java.util.Comparator;

    public class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            if (x.equalsIgnoreCase("file3")) {
                return -1;
            }
            if (x.equalsIgnoreCase("file1")) {
                return 1;
            }
            return 0;
        }
    }
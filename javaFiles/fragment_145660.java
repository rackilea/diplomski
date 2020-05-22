public class Main {

    private static final class NumAndDate {
        private final int num;
        private final Date date;

        NumAndDate(int num, Date date) {
            this.num = num;
            this.date = date;
        }
    }

    public static final class NumAndDateComparator implements Comparator<NumAndDate> {

        @Override
        public int compare(NumAndDate r1, NumAndDate r2) {

            int value = 0;

            value = r1.num - r2.num;

            if (value == 0 && !isValueNull(r1.date, r2.date))
                value = r1.date.compareTo(r2.date);

            return value;
        }

        private boolean isValueNull(Date date, Date date2) {
            return date == null || date2 == null;
        }
    }

    public static void main(String[] args) {
        NumAndDate[] array = {
                new NumAndDate(0, new Date(0)),
                new NumAndDate(0, new Date(1)), 
                new NumAndDate(0, null)
        };
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000; j++) {
                List<NumAndDate> list = new ArrayList<>();
                int[] arr = new int[i];
                for (int k = 0; k < i; k++) {
                    int rand = random.nextInt(3);
                    arr[k] = rand;
                    list.add(array[rand]);
                }
                try {
                    Collections.sort(list, new NumAndDateComparator());
                } catch (Exception e) {
                    System.out.println(arr.length + " " + Arrays.toString(arr));
                    return;
                }
            }
        }
    }
}
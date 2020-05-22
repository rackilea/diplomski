public static void main(String[] args) {
    Arrays.sort(args, new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            return Double.compare(d1, d2);
        }
    });
    ...
}
final int COLUMN = 5;
    Comparator<ArrayList<Double>> myComparator = new Comparator<ArrayList<Double>>() {
        @Override
        public int compare(ArrayList<Double> o1, ArrayList<Double> o2) {
            return o1.get(COLUMN).compareTo(o2.get(COLUMN));
        }
    };
    Collections.sort(list, myComparator);
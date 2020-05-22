public void sortSetByStringLength(Set set) {
    Comparator<String> lengthComparator = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return (a.length() > b.length() ? 1 : -1);
            }
        }
    }

    Collections.sort(set, lengthComparator);
}
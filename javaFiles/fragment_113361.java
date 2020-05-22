Collections.sort(list, new Comparator<Cal>() {
    @Override
    public int compare(Cal cal1, Cal cal2) {
        int result = -cal1.getMonth().compareTo(cal2.getMonth()));
        if (result == 0) {
            result = -cal1.getDate().compareTo(cal2.getDate()));
        }
        return result;
    }
});
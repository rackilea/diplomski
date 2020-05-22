Collections.sort(temp, new Comparator<SMS>() {
    @Override
    public int compare(SMS o1, SMS o2) {
        return Long.compare(Long.parseLong(o1.timestamp), 
                            Long.parseLong(o2.timestamp));
    }
});
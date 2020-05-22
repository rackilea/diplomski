Collections.sort(list, new Comparator<Data>(){
    @Override
    public int compare(Data o1, Data o2) {
        return o1.rollNumber.compareTo(o2.rollNumber);
    }
});
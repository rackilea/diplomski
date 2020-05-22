Collections.sort(mList, new Comparator<YourModel>(){
    public int compare(YourModel obj1, YourModel obj2) {
        return Integer.valueOf(obj1.ID).compareTo(Integer.valueOf(obj2.ID));
        // Or you can compare any field of your object
    }
});
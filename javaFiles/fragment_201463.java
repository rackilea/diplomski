public static void main(String[] args) {
    List<YourClass> list = new ArrayList<>();

    list.add(new YourClass(new Date(100000000), new Date(200000000)));
    list.add(new YourClass(new Date(150000000), new Date(250000000)));
    list.add(new YourClass(new Date(50000000), new Date(300000000)));

    System.out.println(list);

    List<Date> dates = new ArrayList<>();
    for (YourClass yc : list){
        if (!dates.contains(yc.beginning)) dates.add(yc.beginning);
        if (!dates.contains(yc.end)) dates.add(yc.end);
    }

    Collections.sort(dates);

    List<YourClass> list2 = new ArrayList<>();

    for (int i=0; i < dates.size() -1; i++){
        list2.add(new YourClass(dates.get(i), dates.get(i+1)));
    }

    System.out.println(list2);

}

public static class YourClass {
    Date beginning;
    Date end;

    public YourClass(Date beginning, Date end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public String toString() {
        return "\n" + beginning  + " -> " + end ;
    }
}
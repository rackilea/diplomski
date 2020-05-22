List<obj> list = Arrays.asList(new obj(1, 15), new obj(3, 10), new obj(2, 20),
        new obj(2, 10), new obj(3, 25), new obj(2, 50));

Collections.sort(list, new Comparator<obj>() {
    @Override
    public int compare(obj o1, obj o2) {
        if (o1.getMemberid() != o2.getMemberid()) {
            return o1.getMemberid() - o2.getMemberid();
        } else {
            //for the second sort you can use negative to sort descending
            return -(o1.getMembernumber() - o2.getMembernumber());
            //     ^-------------------------------------------------------
        }
    }
});
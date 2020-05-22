Collection<Integer> integers;
boolean oddNumberExists = integers.contains(new Object() {
    public boolean equals(Object e) {
        Integer i = (Integer)e;
        if (i % 2 != 0) return true;
        else return false;
    }
});
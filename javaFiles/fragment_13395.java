List<Integer> list = Arrays.asList(20, 30, 40, 50, 100);
boolean moreThan60 = list.contains(new Object() {
    public boolean equals(Object rhs) {
        return ((Integer)rhs) > 60;
    }
});
System.out.println("moreThan60 = " + moreThan60);
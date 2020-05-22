public List<Integer> m1() {

    List<Integer> returnValues = new ArrayList<Integer>();
    try {
        int a = 10/0;
        System.out.println("Exception created");
        returnValues.add(10);
    } catch(ArithmeticException ae) {
        returnValues.add(15);
    } finally {
        returnValues.add(20);
        return returnValues;
    }
}
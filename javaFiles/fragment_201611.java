public List<Integer> outer() {
    List<Integer> list = new LinkedList<>;
    try {
        parse(list);
    } catch (Exception e) {
        System.out.println("Handle exception!");
    } finally {
        return list;
    }
}
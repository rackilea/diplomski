public static void main(String args[]) throws IOException {

    List<Integer> list = new ArrayList<Integer>();

    list.add(2);
    list.add(232);
    list.add(4);
    list.add(89);
    list.add(77);
    list.add(12);
    list.add(19);

    List<Integer> lowerHalf = medianSplit(list);

    System.out.println("list: " + lowerHalf);
}

public static List<Integer> medianSplit(List<Integer> data) {
    Collections.sort(data);
    return data.subList(0, data.size() / 2);
}
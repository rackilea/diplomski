public static void main(final String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(10); numbers.add(20); numbers.add(30); numbers.add(40);
    //numbers.add(50); numbers.add(60); numbers.add(70);

    ArrayList<Integer> numbers2 = new ArrayList<Integer>();
    numbers2.add(4); numbers2.add(5); numbers2.add(6); numbers2.add(7);
    numbers2.add(8); numbers2.add(9); numbers2.add(10); numbers2.add(11);

    System.out.println("list1: " + numbers);
    System.out.println("list2: " + numbers2);
    List<Integer> interleaved = interleave(numbers, numbers2);

    System.out.println("\nCombined: " + interleaved);
}

public static List<Integer> interleave(
    final List<Integer> list1,
    final List<Integer> list2
) {
    List<Integer> result
        = new ArrayList<Integer>(list1.size() + list2.size());

    Iterator<Integer> it1 = list1.iterator();
    Iterator<Integer> it2 = list2.iterator();
    while (it1.hasNext() || it2.hasNext()) {
        if (it1.hasNext()) {
            result.add(it1.next());
        }
        if (it2.hasNext()) {
            result.add(it2.next());
        }
    }
    return result;
}
for(int i = 0; i < scores.length; i++) {
    SortedSet<Integer> set = map.get(scores[i]);
    System.out.print(scores[i] + ": ");
    Iterator<Integer> iterator = set.iterator();
    System.out.print(iterator.next());
    while(iterator.hasNext()) {
        System.out.print("," + iterator.next());
    }
    System.out.println();
}
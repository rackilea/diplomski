final List<Integer> notYetSorted = lower;
notYetSorted.add(pivot);
notYetSorted.addAll(higher);

System.out.println("During: " + notYetSorted);
// -------------

final List<Integer> sorted = quicksort(lower);
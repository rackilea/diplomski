class MultiListIterator {
  List<Number>[] lists;
  int[] positions;

  MultiListIterator(List<Number>... lists) {
    this.lists = lists;
    positions = new int[lists.length];
  }

  boolean hasNext() {
    for (int i = 0; i < lists.length; i++) {
      if (positions[i] < lists[i].length) return true;
    }
    return false;
  }

  Number next() {
    int bestIndex = -1;
    Number bestNumber = null;
    for (int i = 0; i < lists.length; i++) {
      var p = positions[i];
      if (p >= positions[i].length) continue;
      Number n = lists[i].get(p);
      if (bestNumber == null || n.getValue() < bestNumber.getValue()) {
        bestIndex = i;
        bestNumer = n;
      }
    }
    if (bestNumber == null) throw new RuntimeException("next() beyond hasNext()");
    positions[bestIndex++];
    return bestNumber;
  }
}
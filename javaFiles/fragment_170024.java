public double getPercentageOfPositives(Set<Integer> set) {
    if (set.size() == 0) {
        return 0.0;
    }

    int count = 0;

    for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
        if (iter.next() > 0) count++;
    }

    return 100.0 * count / set.size();
}
static void removeOverlaps(List<Match> matches) {
    Collections.sort(matches, ComplexHighlight::compareLowLengthTag);

    for (int i = 0; i < matches.size() - 1; i++) {
        Interval<Integer> intervalI = matches.get(i).interval;
        for (int j = i + 1; j < matches.size(); j++) {
            Interval<Integer> intervalJ = matches.get(j).interval;
            if (intervalI.getLow() < intervalJ.getHigh() && intervalJ.getLow() < intervalI.getHigh()) {
                System.out.printf("Match %d removed as it overlaps match %d.\n", j, i);
                matches.remove(j--);
            }
        }
    }
}
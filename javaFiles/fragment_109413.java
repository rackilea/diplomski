private static Collector<Emit, ?, Long> countingNonOverlaps() {

    class Acc {
        Emit last;
        long count = 0;

        void add(Emit e) {
            if (last == null || !last.overlapsWith(e)) { count++; last = e; }
        }

        Acc merge(Acc another) {
            throw new UnsupportedOperationException("Parallel not supported");
        }
    }
    return Collector.of(Acc::new, Acc::add, Acc::merge, acc -> acc.count);
}
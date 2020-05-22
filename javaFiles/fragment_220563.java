private static Collector<CheckIn, ?, CheckIn> summary() {
    return Collector.of(
                CheckInSummary::new,
                CheckInSummary::accept,
                CheckInSummary::combine,
                CheckInSummary::finish
           );
}
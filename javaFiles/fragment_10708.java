public static void main(final String... args) {
    final List<Job> jobs = new ArrayList<>();
    jobs.add(new Job(LocalDate.now(), "YES"));
    jobs.add(new Job(LocalDate.now(), "NO"));
    jobs.add(new Job(LocalDate.now(), "YES"));
    jobs.add(new Job(LocalDate.now()
            .minusDays(1), "YES"));

    final Map<LocalDate, Double> result = jobs.stream()
        .collect(
                    Collectors.groupingBy(Job::getDate,
                            Collectors.mapping(Job::getSuccess, Collectors.averagingDouble(success -> {
                                return "YES".equals(success) ? 1 : 0;
                            }))));

    // result = {2014-07-20=1.0, 2014-07-21=0.6666666666666666}
    System.out.println(result);
}
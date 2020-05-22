public static void main(final String... args) {
    final List<Job> jobs = new ArrayList<>();
    jobs.add(new Job(LocalDate.now(), "YES"));
    jobs.add(new Job(LocalDate.now(), "NO"));
    jobs.add(new Job(LocalDate.now(), "YES"));
    jobs.add(new Job(LocalDate.now()
            .minusDays(1), "YES"));

    final Map<LocalDate, String> result = jobs.stream()
            .collect(
                    Collectors.groupingBy(
                            Job::getDate,
                            Collectors.collectingAndThen(
                                    Collectors.mapping(Job::getSuccess, Collectors.averagingDouble(success -> {
                                        return "YES".equals(success) ? 1 : 0;
                                    })), avg -> String.format("%,.0f%%", avg * 100))));
    // result = {2014-07-20=100%, 2014-07-21=67%}
    System.out.println(result);
}
public static void main(String[] args)
    {
        List<Student> students = Arrays.asList(
                new Student("1234", "steve", LocalDate.parse("2019-09-01"),  LocalDate.parse("2019-09-10")),
                new Student("1234", "steve", LocalDate.parse("2019-09-11"),  LocalDate.parse("2019-09-20")),
                new Student("4321", "George", LocalDate.parse("2019-09-01"),  LocalDate.parse("2019-09-10")));

        Map<String, List<String>> result = new HashMap<>();

        Map<String, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getName));

        // finding the minimum start date
        collect.values().forEach(list -> list.stream()
                .min(Comparator.comparing(Student::getStartDate))
                .ifPresent(s -> handleResult(result, s.getId(), s.getName(), s.getStartDate())));
        // finding the maximum end date
        collect.values().forEach(list -> list.stream()
                .max(Comparator.comparing(Student::getEndDate))
                .ifPresent(s -> handleResult(result, s.getId(), s.getName(), s.getEndDate())));
        System.out.println(result);
    }

    private static void handleResult(Map<String, List<String>> result, String id, String name, LocalDate date) {
        if (result.containsKey(id)){
            List<String> strings = result.get(id);
            strings.add(date.toString());
        }else {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(id);
            strings.add(name);
            strings.add(date.toString());

            result.put(id, strings);
        }
    }
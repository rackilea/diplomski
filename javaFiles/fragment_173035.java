Pattern comma = Pattern.compile(",");
try (Stream<String> stream = Files.lines(Paths.get("C:\\data\\sample.txt"))) {
    Map<Integer, Long> numberOfLessonsPassed = stream.skip(1).map(l -> comma.split(l))
            .map(s -> new Student(Integer.valueOf(s[0]), s[1], Integer.valueOf(s[2])))
            .filter(s -> s.getGrade() >= 5)
            .collect(Collectors.groupingBy(Student::getId, Collectors.counting()));
    System.out.println(numberOfLessonsPassed);
} catch (IOException e) {
    e.printStackTrace();
}
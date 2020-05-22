LocalDateTime currentDate = LocalDateTime.now();
String date = DateTimeFormatter.ofPattern("HH:mm").format(currentDate);

Path file = Paths.get("outTest.txt");

if (!Files.exists(file) || Files.size(file) == 0) {
    Files.write(file, List.of(date));
}

Files.lines(file).forEach(System.out::println);
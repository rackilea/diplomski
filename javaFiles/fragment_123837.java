try (Stream<> lines = Files.lines(p, StandardCharsets.UTF_8)) { // 1
    lines.map(line -> line.split(";"))                          // 2
         .forEach(lineAsArray -> {
             if (lineAsArray[0].equals("D")) {
                 insertDoctor(lineAsArray);
             }
             else if (lineAsArray[0].equals("P")) {
                 insertPatient(lineAsArray);
             }
         });
}
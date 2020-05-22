List<Student> student = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new FileReader(new File(infile)))) {
    Pattern p = Pattern.compile("(\\D+)(\\d+)");
    String currentLine;
    while ((currentLine = reader.readLine()) != null) {
        Matcher m = p.matcher(currentLine);
        if (m.matches()) {
            // Assuming `Student` has a `String`, `int` constructor
            student.add(new Student(m.group(1), Integer.parseInt(m.group(2))));
        }
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}
StringBuilder res = new StringBuilder();
String newLine = System.getProperty("line.separator");
for (Course c : arrayCourses) {
    res.append(c);
    res.append(newLine);
}
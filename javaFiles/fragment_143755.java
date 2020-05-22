for (Map.Entry<String, HashMap<String, Student>> letterEntry : students.entrySet()) {
    String letter = letterEntry.getKey();
    // ...
    for (Map.Entry<String, Student> nameEntry : letterEntry.getValue().entrySet()) {
        String name = nameEntry.getKey();
        Student student = nameEntry.getValue();
        // ...
    }
}
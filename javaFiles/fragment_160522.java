private static List<Subject> getSubjects(){

    Subject subject1 = new Subject(1, "Math", (short)2, "");
    Subject subject2 = new Subject(2, "Social Science", (short)4, "Social Science");
    Subject subject3 = new Subject(3, "English", (short)6, "Literature");

    List<Subject> subjects = new ArrayList<>();

    subjects.add(subject1);
    subjects.add(subject2);
    subjects.add(null); 
    subjects.add(subject3);

    return subjects;
}
ListIterator<Student> it = myRoster.listIterator();
while (it.hasNext()) {
    Student b = it.next();
    if (b.getStudentId() == studentId) {
        it.remove(); // Removes b from myRoster
    }
    ...
}
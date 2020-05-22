Iterator<Student> iter = students.iterator();
while (iter.hasNext() {
    Student student = iter.next();
    if (someCondition)
        iter.remove();
}
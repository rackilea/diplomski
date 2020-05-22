public Student bestStudent() {
    Node current = list;
    Student bestStudent = null;
    while(current.next != null) {
        if(bestStudent == null || (current.next != null && (current.data.getGPA() > current.next.data.getGPA()))) {
            bestStudent = current.data;
        }
    }
    return bestStudent;
}
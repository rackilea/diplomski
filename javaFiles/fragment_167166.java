public void insertAt(Course course, int index) {

    if (index == 0) {
        insertAtHead(course);
    }
    else if (index >= currentSize) {
        throw new IndexOutOfBoundsException("Cannot insert course after the tail of the course list");
    }
    else if (index > 0 && index < currentSize) {
        insertAtOccupied(course, index);
    }
}
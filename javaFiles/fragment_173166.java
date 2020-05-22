int index = Collections.binarySearch(borrowRecords, record,
        Comparator.comparing(BorrowBookRecord::getStudentUsername));
if (index < 0) {
    index = -(index + 1);
}
borrowRecords.add(index, record);
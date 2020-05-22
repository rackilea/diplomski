@Override public int compare(final Report record1, final Report record2) {
    int c;
    c = record1.getReportKey().compareTo(record2.getReportKey());
    if (c == 0)
       c = record1.getStudentNumber().compareTo(record2.getStudentNumber());
    if (c == 0)
       c = record1.getSchool().compareTo(record2.getSchool());
    return c;
}
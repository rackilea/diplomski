while (accessDate.hasNext() && hits.hasNext() && visitors.hasNext()) {
    String date = accessDate.next();
    LocalDate localDate = LocalDate.parse(date);
    insert.setObject(1, localDate);
    insert.setInt(2, hits.next());
    insert.setInt(3, visitors.next());
    insert.addBatch();
}
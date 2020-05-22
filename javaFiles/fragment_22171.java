@Test
public void test_date_experimentation() {
    SimpleDateFormat d1Formatter = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");

    // Print the current time in the specified format.
    System.out.println(d1Formatter.format(Date.from(Instant.now())));
}
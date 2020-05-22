public void testYearEnd() {
    for (int i = 1635; i <= 2300; i++) {
        Date date1 = new Date(i, 31, 12);
        Date date2 = new Date(i, 01, 01);
        assertEquals(1, date1.daysTill(date2));
    }
}
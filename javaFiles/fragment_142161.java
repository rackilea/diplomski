@Test
    public void testPattern(){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
                .withLocale(Locale.ENGLISH)
                .withZone(DateTimeZone.UTC);
        long time = formatter.parseDateTime("2013-05-20").getMillis();
        assertEquals(1369008000000L, time);

    }
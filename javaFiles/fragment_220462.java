@Test
    public void findTheGreatTest() {
        SomeBussiness sbi = new SomeBussiness();
        sbi.setDataService(dbService);
        int res = sbi.findTheGreatest();
        assertEquals(1, res);
    }
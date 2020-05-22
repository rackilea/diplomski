@Test
    public void test() {
        CountNumP2 cn = new CountNumP2();
        cn.countUpDown(0, 1);
        String output =  "0\n1\n0\n";
        Assert.assertEquals(output , outContent.toString());
    }
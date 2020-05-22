public class SwitchingTests {
    @Test
    public void testSwitching(){
        Switching switching = new Switching();
        switching.handleInput("123456", 12, "abcdef");
        ArrayList<HashMap> switchingTable = switching.getTable();
        Assert.assertEquals(switchingTable.toString(), "[{123456=12}]");
    }
}
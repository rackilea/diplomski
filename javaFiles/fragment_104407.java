public class TestDrive {

    @Test
    public void testEquality() {

        HeroModels a1 = HeroModels.instance();
        HeroModels a2 = HeroModels.instance();

        Assert.assertEquals(a1, a2);

        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
    }
}
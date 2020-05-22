public class CardsTests {

    @Test
    public void TwoOfHearts() {
        Assert.assertEquals("Two of hearts (value = 2)", Card.fromString("2-H"));
    }

    @Test
    public void ThreeOfHearts() {
        Assert.assertEquals("Three of hearts (value = 3)", Card.fromString("3-H"));
    }

    @Test
    public void ThreeOfSpades() {
        Assert.assertEquals("Three of spades (value = 3)", Card.fromString("3-S"));
    }

}
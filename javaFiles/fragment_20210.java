public class TokenTest {

    @Test
    public void testToken() {
        Token tokenWhite = new Token("WHITE");
        Token tokenBlack = new Token("BLACK");

        assertNotNull("TokenTest-Construct-White", tokenWhite);
        assertNotNull("TokenTest-Construct-Black", tokenBlack);
    }
}
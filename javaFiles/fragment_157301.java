public class SecurityUtilityTest {

    @Test
    public void createsRandomPasswordWithSeed1() {
        // arrange
        Random randomWithFixSeed = new Random(1);

        // act
        String randomPassword = 
           new SecurityUtility(randomWithFixSeed).randomPassword();

        // assert
        assertEquals("seed = 1", "83T81EOKK3ZZB2S9U5", randomPassword);
    }

    @Test
    public void createsRandomPasswordWithSeed2() {
        Random randomWithFixSeed = new Random(2);

        String randomPassword = 
           new SecurityUtility(randomWithFixSeed).randomPassword();

        assertEquals("seed = 2", "EYUT8GG2HYCC95OIH2", randomPassword);
    }
}
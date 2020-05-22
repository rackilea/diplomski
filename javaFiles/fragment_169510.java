public class CostumerTest {
    private final static String VALID_EMAIL = "valid@mail.com";
    private final static int VALID_AGE = 42;
    private final static int VALID_PPS = 42;
    private final static int VALID_NAME = "Bob";


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNameIsNull() {
        Costumer costumer = new Costumer(null, VALID_PPS, VALID_EMAIL, VALID_AGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEmailIsNull() {
        Costumer costumer = new Costumer(VALID_NAME, VALID_PPS, null, VALID_AGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNameIsEmpty() {
        Costumer costumer = new Costumer("", VALID_PPS, VALID_EMAIL, VALID_AGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNegativePPS() {
        Costumer costumer = new Costumer(VALID_NAME, 0, VALID_EMAIL, VALID_AGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCostumerAgeIsLessThan18() {
        Costumer costumer = new Costumer(VALID_NAME, VALID_PPS, VALID_EMAIL, 17);
    }

}
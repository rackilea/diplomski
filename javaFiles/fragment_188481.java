import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MoneyTest {

    @Test
    public void subtract_money_from_smaller_money_should_fail() {
        Money oneDinar = new Money(BigDecimal.valueOf(1));
        Money halfDinar = new Money(BigDecimal.valueOf(0.5));

        String expectedMessage = "Error the Subtracted is in minus...";

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> {
            halfDinar.subtract(oneDinar);
        });

        Assert.assertEquals(expectedMessage, exception.getMessage());
    }
}
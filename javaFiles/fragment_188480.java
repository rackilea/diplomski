import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void subtract_money_from_smaller_money_should_fail() {
        Money oneDinar = new Money(BigDecimal.valueOf(1));
        Money halfDinar = new Money(BigDecimal.valueOf(0.5));

        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                halfDinar.subtract(oneDinar);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
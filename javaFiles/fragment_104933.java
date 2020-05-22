import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Optional;

public class OptionalAsPartialFunction {

  Optional<String> isEven(final int x) {
    return Optional.of(x)
        .filter(i -> i % 2 == 0)
        .map(i -> i + " is even");
  }

  @Test
  public void example() {
    assertThat(isEven(10).get(), equalTo("10 is even"));
    assertThat(isEven(11).isPresent(), is(false));
  }
}
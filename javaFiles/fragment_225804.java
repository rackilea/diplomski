import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

...

assertThat(collection, hasItem(notNullValue(Integer.class)));
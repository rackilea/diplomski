import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

List<String> l = Arrays.asList("foo", "bar");
assertThat(l, hasItems("foo", "bar"));
assertThat(l, not(hasItem((String) null)));
assertThat(l, not(hasItems("bar", "quux")));
// check if two objects are equal with assertThat()

// the following three lines of code check the same thing.
// the first one is the "traditional" approach,
// the second one is the succinct version and the third one the verbose one 
assertEquals(l, Arrays.asList("foo", "bar")));
assertThat(l, is(Arrays.asList("foo", "bar")));
assertThat(l, is(equalTo(Arrays.asList("foo", "bar"))));
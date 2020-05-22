import static org.hamcrest.Matchers.*;

...

testClass.dropFromMap();
assertThat(testClass.set1, containsInAnyOrder(a1, a2));
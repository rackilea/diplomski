import org.hamcrest.AbstractMatcher;

public class StringStartsWithMatcher extends TypeSafeMatcher<String> {
    private String prefix;
    private String calledValue; // ADDED THIS

    public StringStartsWithMatcher(String prefix) {
        this.prefix = prefix;
    }

    public String getCalledValue() {
        return calledValue;
    }

    public boolean matchesSafely(String s) {
        this.calledValue = s; // AND HERE
        return s.startsWith(prefix);
    }

    public StringBuffer describeTo(Description description) {
        return description.appendText("a string starting with ").appendValue(prefix);
    }
}

@Factory
public static Matcher<String> aStringStartingWith( String prefix ) {
    return new StringStartsWithMatcher(prefix);
}

public class MyTestCase {
    ...

    public void testSomething() {
        ...

        TypeSafeMatcher<String> matcher = aStringStartingWith("http")

        context.checking(new Expectations() {{
            oneOf (logger).error(with(matcher));
        }});

        // more tests using matcher.getCalledValue()
        ...
    }
}
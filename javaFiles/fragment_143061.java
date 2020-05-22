@ThreadSafe
@ParametersAreNonnullByDefault
public class RepeatTest implements TestRule {

public static RepeatTest findRepeats() {
    return new RepeatTest();
}

private RepeatTest() {
    super();
}

@Override
public Statement apply(final Statement statement, Description description) {
    return new StatementRepeater(statement, description);
}

private final class StatementRepeater extends Statement {

    private final Statement statement;
    private final int repeatCount;

    private StatementRepeater(Statement statement, Description description) {
        super();
        this.statement = statement;
        Repeat repeat = description.getAnnotation(Repeat.class);
        this.repeatCount = getRepeatCount(repeat);
    }

    private final int getRepeatCount(@Nullable Repeat repeat) {
        int count = 1;
        if (repeat != null) {
            count = repeat.count();
        }

        assertThat("Repeat count must be > 0", count,
                OrderingComparison.greaterThan(0));
        return count;
    }

    @Override
    public void evaluate() throws Throwable {
        for (int i = 0; i < repeatCount; i++) {
            statement.evaluate();
        }
    }
}
}
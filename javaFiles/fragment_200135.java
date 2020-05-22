public class MatcherSpliterator extends AbstractSpliterator<MatchResult> {

    private final Matcher m;

    public MatcherSpliterator(final Matcher m) {
        super(Long.MAX_VALUE, ORDERED | NONNULL | IMMUTABLE);
        this.m = m;
    }

    @Override
    public boolean tryAdvance(Consumer<? super MatchResult> action) {
        if (!m.find()) {
            return false;
        }
        action.accept(m.toMatchResult());
        return true;
    }
}
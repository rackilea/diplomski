public class NoMarkerFilter extends MatchingFilter {

@Override
public FilterReply decide(final Marker marker, final Logger logger, final Level level, final String format,
        final Object[] params, final Throwable t) {
    if (!isStarted()) {
        return FilterReply.NEUTRAL;
    }

    if (marker == null) {
        return onMatch;
    }
    return onMismatch;
}
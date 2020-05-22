@Plugin(name = "InjectMarkerPolicy", category = "Core",
        elementType = "rewritePolicy", printObject = true)
public final class MarkerInjectorRewritePolicy implements RewritePolicy {

    @Override
    public LogEvent rewrite(final LogEvent event) {
        final Marker marker = event.getMarker();
        if (marker == null)
            return event;

        // If there's a Marker, add it to the ThreadContextMap
        // so the RoutingAppender can properly routes log messages

        // event's context map is immutable, so need to make a copy...
        Map<String, String> mdc = new HashMap<>(event.getContextMap());
        mdc.put("_marker", marker.getName());

        LogEvent result = new Log4jLogEvent(event.getLoggerName(), event.getMarker(),
            event.getLoggerFqcn(), event.getLevel(), event.getMessage(),
            event.getThrown(), mdc, event.getContextStack(),
            event.getThreadName(), event.getSource(), event.getTimeMillis());

        return result;
    }
}
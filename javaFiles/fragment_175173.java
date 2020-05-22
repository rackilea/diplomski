/**
 * Gets whether Wicket should try to support opening multiple windows for the same session
 * transparently. If this is true - the default setting -, Wicket tries to detect whether a new
 * window was opened by a user (e.g. in Internet Explorer by pressing ctrl+n or ctrl+click on a
 * link), and if it detects that, it creates a new page map for that window on the fly. As a
 * page map represents the 'history' of one window, each window will then have their own
 * history. If two windows would share the same page map, the non-bookmarkable links on one
 * window could refer to stale state after working a while in the other window.
 * <p>
 * <strong> Currently, Wicket trying to do this is a best effort that is not completely fail
 * safe. When the client does not support cookies, support gets tricky and incomplete. See
 * {@link WebPage}'s internals for the implementation. </strong>
 * </p>
 * 
 * @return Whether Wicket should try to support multiple windows transparently
 */
boolean getAutomaticMultiWindowSupport();
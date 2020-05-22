/**
 * Interface implemented by Element objects that can potentially consume
 * a lot of memory. Objects implementing the LargeElement interface can
 * be added to a Document more than once. If you have invoked setComplete(false),
 * they will be added partially and the content that was added will be
 * removed until you've invoked setComplete(true);
 * @since   iText 2.0.8
 */
public interface LargeElement extends Element
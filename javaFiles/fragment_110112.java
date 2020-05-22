public class CustomSessionStore extends SecondLevelCacheSessionStore {

    @Override
    public void setAttribute(Request request, String name, Object value) {
        super.setAttribute(request, name, value);

        if (Session.get().getSizeInBytes() > SESSION_WARN_LIMIT) {
            log.warn("Session Size is {} bytes", Session.get().getSizeInBytes());
        }
    }
 }
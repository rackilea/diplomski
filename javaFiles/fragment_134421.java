/**
 * Interface for describing the actual function. May (and most likely does)
 * contain other methods too.
 */
public interface BusinessFunction<P extends Profile> {
    public void setProfile(P p);
}
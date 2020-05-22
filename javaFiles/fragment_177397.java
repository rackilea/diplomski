@Singleton
public class MatchesBgService implements Serializable {

    private final MatchLookup ml;
    private final MatchTask bgTask;

    @Inject
    public MatchesBgService(MatchLookup ml, MatchTask bgTask){
        this.ml = ml;
        this.bgTask = bgTask;

        // ...
    }
}
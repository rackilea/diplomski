public class SearchResponse<T  extends SearchResponseHit> implements Iterable<T> {
    List<T> searchResponseHits;

    public Iterator<T> iterator() {
        return searchResponseHits.iterator();
    }
}

public class SearchResponseHit {}

public class SpecialSearchResponse extends SearchResponse<SpecialSearchResponseHit> {}
public class SpecialSearchResponseHit extends SearchResponseHit {}
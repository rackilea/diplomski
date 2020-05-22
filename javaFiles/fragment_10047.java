abstract class AbstractSearchResponse<T  extends SearchResponseHit> implements Iterable<T>{
    List<T> searchResponseHits;

    public Iterator<T> iterator() {
        return searchResponseHits.iterator();
    }
}

public class SearchResponse extends AbstractSearchResponse<SearchResponseHit> { }
public class SpecialSearchResponse extends AbstractSearchResponse<SpecialSearchResponseHit> {}
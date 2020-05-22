public class DocumentURIResolver implements URIResolver {

final Map<String, Document> _documents;

public DocumentURIResolver(final Map<String, Document> documents) {
    _documents = documents;
}

public Source resolve(final String href, final String base) {
    final Document doc = _documents.get(href);
    return (doc != null) ? new DOMSource(doc) : null;
    }
}
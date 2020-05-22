import org.archive.modules.extractor.ContentExtractor;
    import org.archive.modules.extractor.LinkContext;
    import org.archive.modules.extractor.Hop;
    import org.archive.io.ReplayCharSequence;
    import org.archive.modules.CrawlURI;

    public class MyExtractor extends ContentExtractor {
    @Override
    protected boolean shouldExtract(CrawlURI uri) {
        return true;
    }

    @Override
    protected boolean innerExtract(CrawlURI curi) {
        try {
            ReplayCharSequence cs = curi.getRecorder().getContentReplayCharSequence();
            // ... analyse the page content cs as a CharSequence ...

            // decide you want to crawl some page with url [uri] :
            addOutlink( curi, uri, LinkContext.NAVLINK_MISC, Hop.NAVLINK );
    }
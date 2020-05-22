public class CallEngine implements Engine {
    private Analyzer analyzer;
    private Retriever retriever;
    private Uploader uploader;

    public CallEngine(Analyzer analyzer, Retriever retriever, Uploader uploader) {
        this.analyzer = analyzer;
        this.retriever = retriever;
        this.uploader = uploader;        
    }

    public List<Recording> analyze(List<String> files) {
        return analyzer.analyze(files);
    }

    public List<Recording> getMetadata(List<Recording> r) {
        return retriever.getMetadata(r);
    }

    public List<Recording> upload(List<Recording> r) {
        return uploader.upload(r);
    }
}
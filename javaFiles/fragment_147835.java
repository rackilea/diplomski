public interface Analyzer {
    public List<Recording> analyze(List<String> files);
}
public interface Retriever {
    public List<Recording> getMetadata(List<Recording> recordings);
}
public interface Uploader {
    public List<Recording> upload(List<Recording> r);
}
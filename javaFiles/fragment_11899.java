public interface FileProccessor<T> {
    public T setHeader(T header);
}

public class AProcessor implements FileProccessor<Header> {
}
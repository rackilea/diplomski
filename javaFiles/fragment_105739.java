...
import org.springframework.xd.reactor.Processor;
import reactor.rx.Stream;

public class MyReactorStream implements Processor<SomePOJO, SomePOJO> {

    @Value("${intParam}")
    private int intParam;

    @Override
    public Stream<SomePOJO> process(Stream<SomePOJO> inputStream) {
        return inputStream.map(pojo -> {
            ...
            pojo.setIntParam(intParam)
            return pojo;
        });
    }
}
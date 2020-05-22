@Component(metatype = false, immediate = true)
@Service
public class SamplePreprocessor implements Preprocessor {

    @Override
    public void preprocess(ReplicationAction action, ReplicationOptions options) throws ReplicationException {
        if (somethingIsWrong()) {
            throw new ReplicationException("this message will be displayed to the user");
        }
    }
}
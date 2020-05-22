@Service
@Profile("config1")
public class DataConsumerWrapperService {

    public DataConsumerWrapperService(final MessageParser mp) {
        // Do nothing, just trigger the parser bean creation
    }
}
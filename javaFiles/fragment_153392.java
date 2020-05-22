@RequiredArgsConstructor
public class WrongValueInStreamException extends RuntimeException {
    @Getter
    private final Object wrongValue;
}

public class StreamProcessor {
    public String process(Integer value) {
        if (value == 4) {
            throw new WrongValueInStreamException(4);
        }
        return "processed " + value;
    }
}
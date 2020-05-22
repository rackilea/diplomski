@RequiredArgsConstructor
@Getter
public enum SomeChar {
    X('X'), Y('Y');
    private final char asChar;
}

if (a.getAsChar() == 'X') { ...
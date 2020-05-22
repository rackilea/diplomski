@Getter
@Setter
public class SomeEntity {

    @NonNull
    @Contains
    private Collection<String> fieldOne = new ArrayList<>();

    @NonNull
    @Contains
    private Collection<String> fieldTwo = new ArrayList<>();

}
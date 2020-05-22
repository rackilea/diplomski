import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
...

public class Filter {

    @NotNull
    private Integer page;

    @NotEmpty
    private Integer size;

    private String sort;

    ... lots of other parameters
}
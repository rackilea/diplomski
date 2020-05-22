public class View {
    public interface Default{}
    public interface Ignore{}
}

@JsonView(View.Default.class) //this method will ignore fields that are not annotated with View.Default
@RequestMapping(value = "offering", method=RequestMethod.POST)
public ResponseEntity<MyResponse> postOffering(...) {}

//this method will serialize all fields
@RequestMapping(value = "someOtherMethod", method=RequestMethod.POST)
public ResponseEntity<MyResponse> someOtherMethod(...) {}

public class MyResponse { 
    @JsonView(View.Ignore.class)
    private String filed1;
    private String field2;
}
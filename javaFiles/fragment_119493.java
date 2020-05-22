@RunWith(ConcordionRunner.class)
@ConcordionOptions(declareNamespaces={"cx", "urn:error-extension:2017"})
@Extensions(ErrorExtension.class)
public class StackOverflow {

    public String callService() {
        // call your service here
    }
}
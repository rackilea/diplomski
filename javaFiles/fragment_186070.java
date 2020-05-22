public class Names {

    private NamesService service;
    // automatically injected with Spring
    public Names(NamesService service){
       this.service = service;
    }
    ...
}

@Component
public class NamesService implements GenericService {...}
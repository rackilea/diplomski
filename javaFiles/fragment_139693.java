@Service
public class ResourceResolverImpl implements LSResourceResolver {
private ILoadFromSRService iLoadFromSRService;

@Autowired
public ResourceResolverImpl(ILoadFromSRService iLoadFromSRService){
    this.iLoadFromSRService = iLoadFromSRService;
}

public LSInput resolveResource(String type,
                               String namespaceURI,
                               String publicId,
                               String systemId,
                               String baseURI) {
    String string =iLoadFromSRService.getServiceBaseTypeSchema();
    string = string.replace("\n", "").replace("\t", "");
    InputStream resourceAsStream = new ByteArrayInputStream( string.getBytes());
    return new LSInputImpl(publicId, systemId, resourceAsStream);
    }
}
// Sample interface
public interface SkyService {
    public String getMessage();
}

@Path("...")
public class CMSApi {
    private SkyService service;
    public void setSkyService( SkyService service ) { this.service = service; }
}

// Somewhere in test code
CMSApi api = new CMSApi();
SkyServicer service = Mockito.mock(SkyService.class);
Mockito.when(server.getMessage()).thenReturn("Hello World");
api.setSkyService(service);
resourceConfig.register(api);
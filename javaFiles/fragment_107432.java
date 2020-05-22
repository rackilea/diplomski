public class MyService {

    private final TokenService tokenService;
    private final InfoService infoService;

    @Inject
    public MyService(TokenService tokenService,
                     InfoService infoService) {
        this.tokenService = tokenService;
        this.infoService = infoService;
    }
}
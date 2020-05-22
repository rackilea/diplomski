@Inject
public BlahService BlahService;

@MockBean(BlahService.class)
public BlahService blahService(){
    return Mockito.mock(BlahService.class);
}
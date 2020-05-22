@Controller
class MyController{
    @Autowired
    private MyService service;
    @GET
    public String getData(String dataId){
       return service.getData(dataId);
    }
}
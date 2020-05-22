@Component @Lazy 
class ResourceProcessorFoo implements CustomProcessor{
    @Autowired
    public ResourceProcessor(Resource resource) {...}
}
@Component @Lazy 
class ResourceProcessorBar implements CustomProcessor{
    @Autowired
    public ResourceProcessor(Resource resource) {...}
}
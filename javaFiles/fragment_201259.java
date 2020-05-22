@Autowired
private CityRepository cityRepository;
@GetMapping("/test")
public List<City> test(){
    List<City> ret=new ArrayList();
    ret.addAll(cityRepository.findMethod1());
    ret.addAll(cityRepository.findMethod2());
    ret.addAll(cityRepository.findMethod3());
    return ret;
}
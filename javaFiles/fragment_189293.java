@Autowired
@Qualifier("proConfigPropertyFactory")
private Properties configProperties;

public ModelAndView someMethod() {
    return new ModelAndView("TheJspName", "configProperties", configProperties);
}
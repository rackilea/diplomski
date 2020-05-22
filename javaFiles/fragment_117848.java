@Autowire AnInterface ai;

@RequestMapping("/hello")
public String something() {
    ai.doSomething();
    return "/";
}
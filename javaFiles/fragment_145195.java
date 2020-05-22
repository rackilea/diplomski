public class MyController {
    ....
    @Autowired
    SessionDataBean sessionDataBean;

    @RequestMapping(...)
    public ModelAndView controllerMethod(...) {
         ...
         sessionDataBean.setSomeValue(someValue);
    }
}
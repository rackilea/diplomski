package hello;


@RestController
public class RegistrationController implements ApplicationContextAware {

@Autowired
private static ApplicationContext context;

@RequestMapping(value = "/api/register", method = RequestMethod.POST)
public Response registerUser(@RequestParam Map<String,String> req) {
    context = new ClassPathXmlApplicationContext("Spring-Module.xml"); // <--- added this line


    User user = new User(counter.incrementAndGet(),
                    req.get("first"), req.get("last"), req.get("email"), 
                    req.get("age"), Double.parseDouble(req.get("height")), 
                    Double.parseDouble(req.get("weight")), Double.parseDouble(req.get("bmi"))
                    );

    UserDAO userDAO = (UserDAO) context.getBean("userDAO"); 
    userDAO.insert(user);


    return new Response(counter.get(), "200");
}

public static ApplicationContext getApplicationContext() {
    return context;
}

@Override
public void setApplicationContext(ApplicationContext ac) throws BeansException {
    this.context = ac;
    }

}
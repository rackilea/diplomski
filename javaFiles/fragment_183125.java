@Controller
public class HelloController {

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        List<FtpConnection> ftpConnections = new ArrayList<FtpConnection>();
        FtpConnection ftpConnection = new FtpConnection();
        ftpConnection.setUrl("url1");
        ftpConnection.setPort("22");
        ftpConnection.setUsername("user1");
        ftpConnection.setPassword("pass1");
        ftpConnection.setDescription("desc1");

        ftpConnections.add(ftpConnection);

        ftpConnection = new FtpConnection();
        ftpConnection.setUrl("url1");
        ftpConnection.setPort("21");
        ftpConnection.setUsername("user2");
        ftpConnection.setPassword("pass2");
        ftpConnection.setDescription("desc2");

        ftpConnections.add(ftpConnection);
        model.addAttribute("ftpList", ftpConnections);

        model.addAttribute("pojo",new ParamiterPojo());

        return "hello";
    }

    @RequestMapping(value = "/paramiter/create" , method = RequestMethod.POST)
    public String post(@ModelAttribute("pojo") ParamiterPojo paramiterPojo, ModelMap modelMap, Errors errors){
        System.out.println(paramiterPojo);

        return "hello";
    }
}
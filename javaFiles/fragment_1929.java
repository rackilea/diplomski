@Controller
public class CustomerController{

  @Autowired
  Foo obj;
  @RequestMapping(method=RequestMethod.GET,value="addNewCustomer")
   public String addnewCustomer(){      
      obj.storeCustomer("firstname","lastname");
      return "";

   }
}
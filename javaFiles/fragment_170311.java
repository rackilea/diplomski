@Controller
@RequestMapping("/sales")
public class SalesController{

   @RequestMapping(value="/sales-invoice", method = RequestMethod.GET)
   public String salesInvoice(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");

      return "sales/sales_invoice";
   }

}
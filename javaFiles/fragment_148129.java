@Controller
public class ExchangeController {    

   @RequestMapping(path = "/addExchange", method = RequestMethod.POST) 
   public @ResponseBody String addNewExchange (@RequestParam String exchange)
   {
    if (exchange != null ) {
       Exchange e = new Exchange(); 
       e.setE_name(exchange);
       exchangeRepository.save(e); 
       return "Saved Exchange";
    } else {
       return new BadRequestException("exchange name can not be null!");
    }
   }

   @Autowired
   public ExchangeController(ExchangeRepository exchangeRepository) {
       this.exchangeRepository = exchangeRepository;
   }

   private ExchangeRepository exchangeRepository;
}
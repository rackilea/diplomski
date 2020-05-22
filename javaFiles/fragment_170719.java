@Controller
@RequestMapping(value="/charity")
class CharityController {
            @RequestMapping(value = "/accounts", method = RequestMethod.GET)
            public AccountResponseDto getAccount(HttpServletResponse response){

            }
}
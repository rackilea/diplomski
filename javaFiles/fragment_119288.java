@Controller
@RequestMapping("/address")
public class AddressController {
  private String getMainPage(
    ModelMap model,
    HttpSession session
  ){
    if(!model.containsAttribute("address"))
      model.addAttribute("address", new Address());
...
    return TILE_GET_STARTED_ADDRESS;
}

@RequestMapping(value = URL_ADDRESS_SELECT, method = RequestMethod.POST)
public String validateAddress(
  @Valid Address address,
  BindingResult result,
  Model model,
  RedirectAttributes attr,
  HttpSession session
) throws StdAddFault {
  if(result.hasErrors()) {
    attr.addFlashAttribute("org.springframework.validation.BindingResult.address", result);
    attr.addFlashAttribute("address", address);
    return "redirect:/address";
  }
  ....
}
}
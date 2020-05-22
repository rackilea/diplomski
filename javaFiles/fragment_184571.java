@RequestMapping(value = "/datedata", method = RequestMethod.POST)
public String create(
    @ModelAttribute("datedata") final DateData datedata,
    final BindingResult result) {

    if (result.hasErrors()) {
        return "datedata/create";
    } else {
        ...
        return "myView";
    }
 }
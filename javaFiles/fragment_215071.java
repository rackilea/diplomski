@RequestMapping(value = "/{id}", method = RequestMethod.POST)
public OutletIndex updateOutlet(@PathVariable String id,
                                @ModelAttribute("OutletIndex") @Valid OutletIndex outlet,
                                BindingResult resultOutlet,
                                @ModelAttribute("FileWrappers") FileWrappers fileWrappers,
                                BindingResult resultWrappersoutletImage
) {
   //....
}
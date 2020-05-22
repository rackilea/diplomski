@RequestMapping("/")
public String create(@Valid @ModelAttribute Device device, BindingResult bindingResult) {
    if(device.getName().length() < 6)
        bindingResult.addError(new FieldError("device", "name",device.getName(), false, null, null, "custom error"));
    return getDefaultView();
}
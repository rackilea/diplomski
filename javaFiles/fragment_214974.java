@PostMapping(value="/save")
public String save(@Valid Doctor dr,  BindingResult bindingResult){
    Doctor prevDr = doctorService.getById(dr.getId());
    dr.setUserId(prevDr.getUserId());
    doctorValidator.validate(dr, bindingResult);
    if (bindingResult.hasErrors()) {
        return "object-form";
    }
    else{
        doctorService.save(dr);
        return "redirect:list";
    }
}
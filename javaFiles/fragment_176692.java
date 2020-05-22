@RequestMapping(value="unit/unitAdd.do", method=RequestMethod.POST)
public final String saveUnitAdd(@Valid @ModelAttribute("pmiUnitObject) PmiUnit pmiUnit, BindingResult bindingResult, Model model, HttpSession session){
    logger.info("saveAddUnit called!");
    boolean exists = unitService.isAlreadyExists("pmi_units", "uni_unit_name_pk",pmiUnit.getUniUnitNamePk());
    if (exists) {
        //exists and without state DEL, return exists error
        logger.info("Unit Name_PK exists");
        if(!unitService.isExistsAndDeleted("pmi_units", "uni_unit_name_pk",pmiUnit.getUniUnitNamePk())) {
            System.out.println("exists and not deleted");
            bindingResult.rejectValue("uniUnitNamePk", "pmi.validator.constraints.unique");}
            //exists but with state DEL, update this row
        }
    }

    if (!bindingResult.hasErrors() ) {
        unitService.updateDeletedUnit(pmiUnit);
        mainService.getDefaultPmiUnit(pmiUnit, model);
        model.addAttribute("fromAddUnit", "true");
        model.addAttribute("addResult", "true");
        return "accessControl1/unit/unitManage";
    } else {
        return "accessControl1/unit/unitAdd";
    }

}
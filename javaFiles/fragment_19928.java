public String save(final Cat cat
        , final BindingResult bindingResult, final ModelMap model){
    if(bindingResult.hasErrors()){
        logger.info("Binding result error in create(save)");
        return "cat/create";
    }
    //manually reassign - start
    List<CatDt> catDts = cat.getCatDts();
    for (CatDt catDt : catDts) {
        catDt.setCat(cat);
    }
    cat.setCatDts(catDts);
    //manually reassign - end

    Cat updatedCat = catService.save(cat); //saveAndFlush
    model.clear();
    return "redirect:/cat/create";

}
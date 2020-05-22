@RequestMapping
public String preferences(@ModelAttribute PreferencesDto preferencesDto, BindingResult result, ModelMap modelMap, HttpServletRequest request) {        
    modelMap.addAttribute("preferencesDto", preferencesDto);
        // Manage available data
        modelMap.addAttribute("languagesAvailable", languageService.getEuropeanLanguage());        

        // pre-filled DTO with prefered languages
        preferencesDto.setLanguages(getPreferedLanguages(request));

    return "preferences";
}

/** Manage preferences languages for user logged */
private List<Language> getPreferedLanguages(HttpServletRequest request) {
        final List<Language> languagesSelected = new ArrayList<Language>(0);
        // TODO : call a service to get the prefered language for the logged user and fill the list
        return languagesSelected;
}
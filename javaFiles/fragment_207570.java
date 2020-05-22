@RequestMapping(method=RequestMethod.POST)
public String processSubmit(@Valid @ModelAttribute("questions") VoterBean questions, BindingResult result) {
    if (result.hasErrors()) {
        logger.info("QuestionController encountered form errors ");
        return "questionPage";
    }
    return "redirect:/ballot/get";
   }
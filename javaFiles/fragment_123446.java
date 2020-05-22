@GetMapping("/normal/start-dag")
public String opretGoal(Model model) {
    ...
    StartDay startDay = .... // e.g. new StartDay();
    model.addAttribute("startDay", startDay);
    ...
    return "normal/start-dag";
}

@PostMapping("/normal/start-dag")
public String opretGoal(@Valid StartDay startDay, BindingResult bindingResult, Model model)
{
    if (bindingResult.hasErrors()) {
        // log and/or handle errors
    }
    else {
        // your logic goes here
        startDayService.createGoalOfTheDay(startDay);
    }
    return "/normal/menu";
}
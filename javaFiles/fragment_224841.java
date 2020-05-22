@RequestMapping(method = RequestMethod.GET)
public String getMeetings(Model model) {
    model.addAttribute("meetings", meetingList());
    model.addAttribute("meeting", new Meeting());
    return "meetings";
}
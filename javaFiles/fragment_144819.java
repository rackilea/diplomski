@RequestMapping(method = RequestMethod.POST)
public String postForm(@ModelAttribute("teamBean") TeamBean teamBean) {
    System.out.println("DynaminFormController.postForm()");
    System.out.println(teamBean);//printing null
    return "view";
}
@RequestMapping(value = "/add", params = "submit", method = RequestMethod.POST)
public ModelAndView addForm(@ModelAttribute PostModel newPost){
    System.out.println("Added " + newPost.getQuestion() + " successfully");
    System.out.println("Added the file " + file.getName() + "successfully");
    return addController.showNotice(newPost.getQuestion());
}
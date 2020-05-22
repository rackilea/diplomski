public String handlePost(@ModelAttribute YourObject model, BindingResult result, SessionStatus status) {
    if (result.hasErrors) {
         return "yourView";
    } else {
         status.isComplete();
         yourObjectDao.save(model);
         return "redirect:your-new-view";
    }
}
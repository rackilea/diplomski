@RequestMapping(value = "/log/delete", method = RequestMethod.POST, params = "delete")
public String deleteLogs(@ModelAttribute("deleteForm") logDeleteForm deleteForm) {
    List<Long> formIds = deleteForm.getLogIds();
    if (formIds == null || formIds.size() == 0) {
        return "redirect:/projects/log";
    }
    for (Long id : formIds) {
        logService.deleteLog(id);
    }
    return "redirect:/projects/log";
}
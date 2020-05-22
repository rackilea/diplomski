if (changeEmailResult.hasErrors()) {
    return new ModelAndView("/client/editEmail");
}
try {
    clientService.updateUserEmail(user.getName(),
                                  changeEmailBean.getCurrentPassword(),
                                  changeEmailBean.getNewEmail());
} catch (InvalidPasswordException unused) {
    ModelAndView model = new ModelAndView("/client/editEmail");
    model.addObject("wrongPassword", "Password doesn't match to real");
    return model;
} catch (DuplicateEmailException unused) {
    ModelAndView model = new ModelAndView("/client/editEmail");
    model.addObject("email", oldEmail);
    model.addObject("emailExists", "Such email is registered in system already");
    return model;
}
refreshUsername(newEmail);
return new ModelAndView("redirect:/client/profile");
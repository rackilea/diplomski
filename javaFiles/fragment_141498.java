@DeleteMapping(value = "/users/{id}/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteUser(@PathVariable("id") Long idx, final RedirectAttributes redirectAttributes) {

        logger.debug("Delete user with Id {}", idx);

        redirectAttributes.addFlashAttribute("css", "Success");
        redirectAttributes.addFlashAttribute("msg", "The user is deleted");

        // delete the user
        userService.delete(idx);
        return "redirect:/users/";
    }
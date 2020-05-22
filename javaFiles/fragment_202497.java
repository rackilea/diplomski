@RequestMapping(value = URL_USER + "/{id}", method = RequestMethod.GET)
@ResponseBody
public PersistentEntityResource get(PersistentEntityResourceAssembler persistentEntityResourceAssembler, @PathVariable Long id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    ApplicationUser loggedInUser = applicationUserService.findByUsername(authentication.getName());
    ApplicationUser applicationUser = applicationUserService.findById(id);

    if (applicationUser.getId().equals(loggedInUser.getId())) {
        return persistentEntityResourceAssembler.toFullResource(applicationUser);
    }

    throw new ForbiddenRequestException("Access not allowed");
}
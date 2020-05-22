@ModelAttribute("numRequests")
public int numRequests(Principal principal, Model model) {
    Users user = usersRepository.findOneByInitialName(principal.getName());
    if (user != null) {
        log.info(user.getId().toString());

        // TODO Find all APPROVED requests if user is EMPLOYEE and all PENDING requests is user is MANAGER
        // TODO Reset to 0 once we hit /requests page
        // TODO Update this value on page refresh if not on /requests page

        List<RequestDO> requestsList = requestRepository.findByUsersAndStatus(user, RequestStatus.PENDING);

        int numRequests = requestsList.size();
        log.info(String.valueOf(numRequests));
        model.addAttribute("numRequests", numRequests);
        return numRequests;
    }
    return 0;
}
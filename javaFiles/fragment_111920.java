@Service
    @Transactional
    Public class Controller implements someInterface {

    public LoggedInUser getUser() {
        LoggedInUser user = (LoggedInUser )SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
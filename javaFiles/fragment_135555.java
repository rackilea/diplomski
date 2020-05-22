@RequestMapping(value="/endsession", method = RequestMethod.GET)
public String endSession(String sessionId, Principal principal) {
    logger.info("Removing sessionID = " + sessionId);       
    sessionRegistry.getSessionInformation(sessionId).expireNow();

    return "activeusers";
}
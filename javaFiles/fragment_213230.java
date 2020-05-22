@RequestMapping(value = "/signup", method = RequestMethod.POST)
public ResponseEntity<String> signup(@RequestBody CustomUserDetails user, HttpServletResponse response) {

    String userName = user.getUsername();
    logger.debug("User signup attempt with username: " + userName);

    try{
        if(customUserDetailsService.exists(userName))
        {
            logger.debug("Duplicate username " + userName);
            return new ResponseEntity<String>(HttpStatus.OK);
        } else {
            customUserDetailsService.save(user);
            authenticateUserAndSetSession(user, response);
        }
    } catch(Exception ex) {
    }
    return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
}
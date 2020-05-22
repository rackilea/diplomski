public ModelAndView getChats(HttpServletRequest request,
                               HttpServletResponse response) {
    String email = (String) request.getSession().getAttribute("email");        
    if (email == null) {
        // user is not logged in, deal with it.
    } else {
        List<Chat> chats = _chatDao.getChats(email);
        return new ModelAndView("chatView", "chats", chats);
    }
}
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    // declare and initialize lock and sessionAuthMap at some point...
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
            HttpServletResponse response, Authentication authentication) 
            throws ServletException, IOException {
        lock.writeLock().lock();
        try {
            sessionAuthMap.put(request.getSession().getId(), authentication);
        } finally {
            lock.writeLock().unlock();
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
public class VaadinSessionListener{

    private static volatile int activeSessions = 0;

    public static class VaadinSessionInitListener implements SessionInitListener{

        @Override
        public void sessionInit(SessionInitEvent event) throws ServiceException {

            incSessionCounter();            
        }
    }

    public static class VaadinSessionDestroyListener implements SessionDestroyListener{

        @Override
        public void sessionDestroy(SessionDestroyEvent event) {

            /*
             * check if HTTP Session is closing
             */
            if(event.getSession() != null && event.getSession().getSession() != null){

                decSessionCounter();
            }
        }
    }


    public static Integer getActiveSessions() {
        return activeSessions;
    }

    private synchronized static void decSessionCounter(){
        if(activeSessions > 0){
            activeSessions--;
        }
    }

    private synchronized static void incSessionCounter(){
        activeSessions++;
    }
}
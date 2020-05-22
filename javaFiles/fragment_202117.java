class SessionObject implements HttpSessionBindingListener {
        String message = "";
        User loggedInUser;
        Logger log = Logger.getLogger(SessionObject.class);
        public SessionObject(User loggedInUser) {
            this.loggedInUser=loggedInUser;
        }

        public void valueBound(HttpSessionBindingEvent event) {
            log.info("=========in valueBound method==============");
            HttpSession session =LoggedInUserSessionUtil.getLogggedUserMap().get(loggedInUser);
            try{
                if (session != null && session.getLastAccessedTime() != 0) {
                    message = "ALL_READY_LOGGEDIN";
                    return;
                }
            }catch(IllegalStateException e){
                e.printStackTrace();
                session = LoggedInUserSessionUtil.removeLoggedUser(loggedInUser);
            }
            System.out.println("*************************************"+event.getSession().getId() +"------"+loggedInUser+"*********************************************");
            log.info("=========valueBound putting in user map==============");
            LoggedInUserSessionUtil.getLogggedUserMap().put(loggedInUser, event.getSession());
            return;
        }

        public void valueUnbound(HttpSessionBindingEvent event) { 
             // This work already doing in Force logout servlet
             }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;


        }
    }
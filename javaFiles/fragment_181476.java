for (Object object : principals) {
        LdapUserDetailsImpl user = (LdapUserDetailsImpl) object;
        List<SessionInformation> sessions = sessionRegistry.getAllSessions(user, false);
        String username = user.getUsername();

        for (SessionInformation session : sessions) {
            LoginUserInfo userInfo = new LoginUserInfo();
            Date lastRequest = session.getLastRequest();
            String sessionId = session.getSessionId();

            userInfo.setUsername(username);
            userInfo.setIp(remoteAddress);
            userInfo.setLastActivity(lastRequest.getTime());
            userInfo.setSessionId(sessionId);

            userSessionData.add(userInfo);
        }           
    }
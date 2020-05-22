if (response.getStatusCode() == Response.PROXY_AUTHENTICATION_REQUIRED
                    || response.getStatusCode() == Response.UNAUTHORIZED) {
                AuthenticationHelper authenticationHelper = 
                    ((SipStackExt) sipStack).getAuthenticationHelper(new AccountManagerImpl(), headerFactory);

                inviteTid = authenticationHelper.handleChallenge(response, tid, sipProvider, 5);

                inviteTid.sendRequest();

                invco++;
            }
227        // Is this the action request from the login page?
228        boolean loginAction =
229            requestURI.startsWith(contextPath) &&
230            requestURI.endsWith(Constants.FORM_ACTION);
231
232        // No -- Save this request and redirect to the form login page
233        if (!loginAction) {
234            session = request.getSessionInternal(true);
235            if (log.isDebugEnabled())
236                log.debug("Save request in session '" + session.getIdInternal() + "'");
237            try {
238                saveRequest(request, session);
239            } catch (IOException ioe) {
240                log.debug("Request body too big to save during authentication");
241                response.sendError(HttpServletResponse.SC_FORBIDDEN,
242                        sm.getString("authenticator.requestBodyTooBig"));
243                return (false);
244            }
245            forwardToLoginPage(request, response, config);
246            return (false);
247        }
248
249        // Yes -- Validate the specified credentials and redirect
250        // to the error page if they are not correct
251        Realm realm = context.getRealm();
252        if (characterEncoding != null) {
253            request.setCharacterEncoding(characterEncoding);
254        }
255        String username = request.getParameter(Constants.FORM_USERNAME);
256        String password = request.getParameter(Constants.FORM_PASSWORD);
257        if (log.isDebugEnabled())
258            log.debug("Authenticating username '" + username + "'");
259        principal = realm.authenticate(username, password);
260        if (principal == null) {
261            forwardToErrorPage(request, response, config);
262            return (false);
263        }
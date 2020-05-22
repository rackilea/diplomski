96         // Was our form the one that was submitted?  If so, we need to set
97         // the indicator accordingly..
98         Map<String, String> requestParameterMap = context.getExternalContext()
99               .getRequestParameterMap();
100        if (requestParameterMap.containsKey(clientId)) {
101            if (logger.isLoggable(Level.FINE)) {
102                logger.log(Level.FINE,
103                           "UIForm with client ID {0}, submitted",
104                           clientId);
105            }
106            ((UIForm) component).setSubmitted(true);
107        } else {
108            ((UIForm) component).setSubmitted(false);
109        }
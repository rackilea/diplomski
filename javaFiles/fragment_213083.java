SAMLToken samlToken = (SAMLToken) AccessController
                        .doPrivileged(new java.security.PrivilegedExceptionAction() {
                            public Object run() throws java.lang.Exception {
                                final java.util.Iterator authIterator = subject
                                        .getPrivateCredentials(SAMLToken.class)
                                        .iterator();
                                if (authIterator.hasNext()) {
                                    final SAMLToken token = (SAMLToken) authIterator
                                            .next();
                                    return token;
                                }
                                return null;
                            }
                        });
            // Log attribute name and values
                List<SAMLAttribute> attributes = samlToken.getSAMLAttributes();
                if (attributes != null && !attributes.isEmpty()) {
                    for (SAMLAttribute attr : attributes) {
                        logger.debug(attr.getName());
                        if (attr.getStringAttributeValue() != null) {
                            for (int i = 0; i < attr.getStringAttributeValue().length; i++) {
                                logger.debug(attr.getStringAttributeValue()[i]);
                            }

                        }
                    }
                }
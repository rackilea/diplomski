final PasswordAuthentication AUTHENTICATOR = new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                Authenticator.setDefault(new Authenticator()
                {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        if( ObjectUtil.equals(getRequestorType(), Authenticator.RequestorType.PROXY) ) {
                            return AUTHENTICATOR;
                        }
                        return null;
                    }
                });
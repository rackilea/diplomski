User user = new User(name);
user.setEmail(email);
OAuthLogin fbLogin = new OAuthLogin(user, OAuthProvider.FACEBOOK, "1501791394");      
user.getOauthLogins().add(fbLogin) // this is enough assuming uni-directional association
userDAO.persist(user);
List<OAuthLogin> oauthLogins = user.getOauthLogins();
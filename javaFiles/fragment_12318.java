Map<String, String> attributes = new HashMap<String, String>();
attributes.put("email", "http://schema.openid.net/contact/email");
OpenID.redirectURL(
  openid, 
  routes.Application.openIDCallback.absoluteURL(request()), 
  attributes
);
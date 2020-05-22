CxfEndpoint cxfEndpoint = camelContext.getEndpoint(“cxf:xxx”); 
// set the authentication information 
Map<String, Object> properties = new HashMap<String, Object>(); 

org.apache.cxf.configuration.security.AuthorizationPolicy authPolicy = new AuthorizationPolicy(); 
authPolicy.setUserName(username); 
authPolicy.setPassword(password); 
properties.put(AuthorizationPolicy.class.getName(), authPolicy); 

cxfEndpoint.setProperties(properties);     

from(“xxx”).to(cxfEndpoint);
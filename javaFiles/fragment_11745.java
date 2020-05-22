// source object
JSONObject sourceObject = new JSONObject(sourceJson);

String tokenKey = "token";
// create new object for token
JSONObject tokenObject = new JSONObject();

// transplant token to new object
tokenObject.append(tokenKey, sourceObject.remove(tokenKey));
// if append method does not exist use put
// tokenObject.put(tokenKey, sourceObject.remove(tokenKey));

System.out.println("Token object => " + tokenObject);
System.out.println("User object => " + sourceObject);
// to store cookie value in the format of 
// language + "_" + country + "_" 
//   + (variant + "_#" | "#") + script + "-" + extensions
String cookieValue_fullLength = new Locale( "tr", "TR" ).toString();
Cookie localeCookie_fl = new Cookie( "locale_fl", cookieValue_fullLength );
response.addCookie( localeCookie_fl );

// to store cookie value in the format of "language"
String cookieValue_Language = new Locale( "tr", "TR" ).getLanguage();
Cookie localeCookie_lang = new Cookie( "locale", cookieValue_Language );
response.addCookie( localeCookie_lang );
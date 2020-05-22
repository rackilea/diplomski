// FQL query which asks Facebook for your friends' names,
// profile picture URLs, and network affiliations

String query =
  "SELECT name, pic_big, affiliations FROM user " +
  "WHERE uid IN (SELECT uid2 FROM friend WHERE uid1=12345)";

// Executes an API call with result mapped to a list of classes we've defined.
// Note that you can pass in an arbitrary number of Parameters - here we
// send along the query as well as the "give me HTTPS URLs" flag

List<User> users =
  facebookClient.executeForList("fql.query", sessionKey, User.class,
    Parameter.with("query", query), Parameter.with("return_ssl_resources", "true"));
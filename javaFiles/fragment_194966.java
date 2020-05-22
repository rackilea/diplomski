@WebMethod
List<String> getCustomerUsernames()
{
  List<String> usernames = new ArrayList<String>();

  //your query here to get the usernames from the DB and for each username:
  usernames.add(username);

  return usernames;
}
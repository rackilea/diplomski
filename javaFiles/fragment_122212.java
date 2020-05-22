UUID id = UUID.randomUUID();
String t = id.toString();
//your link generation goes here
String link  = baseUrl+"/register?token="+t;
//Save the token in db with a field expired=false
Token token = new Token();
token.setUuid(t);
token.setCreatedDate(new Date());
token.setExpired(false);
tokenRepo.save(token)
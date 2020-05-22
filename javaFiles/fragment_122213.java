//let t be the captured token
Token token = tokenRepo.findByUuid(t);
if(token.expired){
//tell them link is expired
}else{
token.setExpired(true)
//give them the reg page and take it from here
}
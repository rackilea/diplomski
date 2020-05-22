DrawUnusedBalance drawUnusedBalance = null;
try{
drawUnusedBalance = (DrawUnusedBalance)query.getSingleResult()
catch (NoResultException nre){
//Ignore this because as per your logic this is ok!
}

if(drawUnusedBalance == null){
 //Do your logic..
}
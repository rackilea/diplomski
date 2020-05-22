int i = 0; 
for(String s : params){
    post.addParam(s);
    if( ++i % 10 == 0){
         post.sendRequest();
    }
}
//If the last `addParam` was not sended, we check again.
if( i % 10 != 0){
     post.sendRequest();
}
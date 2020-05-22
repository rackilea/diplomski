int MAX_RETRY = 10
int retryCount = 0
while(retryCount < MAX_RETRY){
    try{
        //something
    }
    catch(SomeException e){
        //display error message 'an exception occurred try again'
        //go back to try statement
        retryCount++;
    }
}
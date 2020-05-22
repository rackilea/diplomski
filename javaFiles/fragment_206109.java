int max_attempts = 10;
int attempts = 0;

while(attempts < MAX_ATTEMPTS){
  try{
     //do something
     attempts += MAX_ATTEMPS; //done
  }catch(Exception ex){
     //do something
  }
  attempts++;
}
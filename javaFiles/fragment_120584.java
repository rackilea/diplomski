final static int MAX_PINGS = 10;
final static int TIMEOUT= 10000;
int countFailed = 0;

for (int i=0; i<MAX_PINGS; i++){
    if (address.isReachable(TIMEOUT)){
         System.out.println("Pinged successfully");
         break;
    }else{
         countFailed++;
    }
 }
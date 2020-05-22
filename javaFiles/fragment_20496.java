public int compareTo(Account a){
if(balance<a.getBalance())
     return -1; 
if(balance==a.getBalance())
     return 0; 
else
     return 1; 

}
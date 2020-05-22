public void transfer(Account a,Account b,int amount)
    {
       //define a specific order, in which locks are acquired
       //the id's of all accounts are unique!
       if(a.id<b.id){
          synchronized(a){
            synchronized(b){
               //do operations here
            }
          }
       }else{
          synchronized(b){
            synchronized(a){
               //do operations here
            }
          }
       }
    }
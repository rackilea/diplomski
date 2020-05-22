public void transfer(Account a,Account b,int amount)
{
    while(true){
      synchronized(a){
          if(a.balance>=amount){
              //do operations here
          }
      }

        try{Thread.sleep(500);} //Use this as a backoff, as otherwise you'd likely get high congestion
        catch(Exception e){System.out.println(e);}
    }
    synchronized(b)
    {
       //do operations here
    }
}
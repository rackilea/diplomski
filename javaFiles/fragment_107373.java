@WebMethod(operationName = "getSalt")
public String getSalt() {
synchronized(waitLock)
{
  //wait until ip is already in use
  //could wait a lot
  synchronized(saltLock)
  {
     //modify resource
  }
}


@WebMethod(operationName = "doSmt")
public String doSmt()
{
   //some code...
  synchronized(saltLock)
  {
     //modify resource
     synchronized(waitLock) {
      // some code
     }
  } 
}
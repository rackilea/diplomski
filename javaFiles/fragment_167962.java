public List<Integer> recv_getEntityByIP() throws org.apache.thrift.TException
{
  getEntityByIP_result result = new getEntityByIP_result();
  receiveBase(result, "getEntityByIP");
  if (result.isSetSuccess()) {
    return result.success;
  }
  throw new org.apache.thrift.TApplicationException(  
        org.apache.thrift.TApplicationException.MISSING_RESULT, 
        "getEntityByIP failed: unknown result");
}
@WebMethod(operationName = "initiateBatchProcess")
  public @WebResult(name = "Response") ArrayList initiateBatchProcess(@WebParam (name = "BatchID")int BatchId, @WebParam (name = "MPTRef")String MPTRef) throws MyServiceException
  {
      ArrayList returnValue = null;
      try {
          returnValue = result.initiateBatchProcess();
      } catch (Exception e) {
          throw new MyServiceException(e);
      }

      return returnValue;
  }
@WebMethod(operationName="initBatch")
public RezultSet initiateBatchProcess(String status, int batchID) {

      //do stuff

    ResultSet result = new ResultSet();
    result.setStatus(status);
    result.setBatchId(batchID);
    return result;
    /*
    *Or you can do something like 
    *return new ResultSet(status, batchID);
    */

}
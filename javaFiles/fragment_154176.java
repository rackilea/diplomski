class DAOException extends RuntimeException{
 private int errorCode;
 private String errorMessage;
 private Exception originalException;

 DAOException(int errorCode, String errorMessage, Exception originalException){
    this.errorCode=errorCode;
    this.errorMessage=errorMessage;
    this.originalException=originalException;
    }

}
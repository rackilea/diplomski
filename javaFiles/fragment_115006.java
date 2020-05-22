abstract class HandlerParams {    
}       

interface FileHandler<T extends HandlerParams> {
  boolean uploadFile(T parameters);
  OutputStream downloadFile(T parameters);
}
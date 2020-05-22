Class clazzSocks  = socket.getClass();
Method setSockVersion  = null;
Field sockImplField = null; 
SocketImpl socksimpl = null; 
try {
  sockImplField = clazzSocks.getDeclaredField("impl");
  sockImplField.setAccessible(true);
  socksimpl  = (SocketImpl) sockImplField.get(socket);
  Class clazzSocksImpl  =  socksimpl.getClass();
  setSockVersion  = clazzSocksImpl.getDeclaredMethod("setV4");
  setSockVersion.setAccessible(true);
  if(null != setSockVersion){
      setSockVersion.invoke(socksimpl);
  }
  sockImplField.set(socket, socksimpl);
} catch (Exception e) {

}
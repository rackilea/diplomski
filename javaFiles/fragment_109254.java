public class ServerClientSocket extends ServerSocket {
  public ClientSocket accept() throws IOException {
  if (isClosed())
    throw new SocketException("Socket is closed");
  if (!isBound())
    throw new SocketException("Socket is not bound yet");
  ClientSocket s = new ClientSocket((SocketImpl) null);
  implAccept(s);
  return s;
  }
}
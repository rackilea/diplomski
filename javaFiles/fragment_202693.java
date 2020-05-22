int inDataLength=recv(Socket,buffer,sizeof(buffer),0);
if (inDataLength == -1 ) {
    std::cerr << "receive error: " << GetLastError() << std::endl;
    return false;
}
...
int main(int argc, char* argv[])
{

    WSAData version;        //We need to check the version.
    WORD mkword=MAKEWORD(2,2);
    int what=WSAStartup(mkword,&version);
    if(what!=0){
    std::cout<<"This version is not supported! - \n"<<WSAGetLastError()<<std::endl;
    }
    else{
    std::cout<<"Good - Everything fine!\n"<<std::endl;
    }

    SOCKET u_sock=socket(AF_INET,SOCK_STREAM,IPPROTO_TCP);
    if(u_sock==INVALID_SOCKET)
    std::cout<<"Creating socket fail\n";

    else
    std::cout<<"It was okay to create the socket\n";

    //Socket address information
    sockaddr_in addr;
    addr.sin_family=AF_INET;
    addr.sin_addr.s_addr=inet_addr("127.0.0.1");
    addr.sin_port=htons(15000);
    std::cout<<"Successfully provided the address"<<std::endl;    
    /*==========Addressing finished==========*/

    //Now we connect
    int conn=connect(u_sock,(SOCKADDR*)&addr,sizeof(addr));
    std::cout<<"conn value:"<<conn<<std::endl;
    if(conn==SOCKET_ERROR){
    std::cout<<"Error - when connecting "<<WSAGetLastError()<<std::endl;
    closesocket(u_sock);
    WSACleanup();
    }
     std::cout<<"Successfully connected to server"<<std::endl;

     //Send some message to remote host
    char* mymsg="Hello Server...How are you?";
    int length = strlen(mymsg);
    //Cast the integer to char and send it
    int smsg=send(u_sock,reinterpret_cast<char*>(&length), sizeof(int),0);
    //Send the actual message
    smsg=send(u_sock,mymsg,strlen(mymsg),0);


    int newlength;
    //Receive exactly 4 bytes for the length. If not the right length is received, repeat.
    int get = 0;
    while((get+=recv(u_sock,(reinterpret_cast<char*>(&newlength))+get,4,0)) < 4) {}
    std::cout<<"Length: " << newlength << std::endl;
    //Create new char array with newlength + 1 so we have a zero terminated string.
    char* newMsg = new char[newlength+1];
    memset(newMsg,0,newlength+1);
    get = 0;
    //Receive the string. If not the right length is received, repeat.
    while((get+=recv(u_sock,newMsg+get,newlength,0)) < newlength) {}
    std::cout<<"Message: " << newMsg << std::endl;

    closesocket(u_sock);


    int i;
    std::cin >> i;
    return 0;
}
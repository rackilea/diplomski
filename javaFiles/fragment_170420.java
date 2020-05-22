DataInputStream input = new DataInputStream(clientSock.getInputStream());
String clientType = input.readUTF();

switch(clientType){
    case "Resource":
        new Thread(new ResourceService(input)).start();
        break;
    case "User":
        new Thread(new UserService(input)).start();
        break;
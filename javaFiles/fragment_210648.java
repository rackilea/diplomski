public interface ServerMessageDocument extends org.apache.xmlbeans.XmlObject {
    ...
    org.example.www.service.ServerMessage getServerMessage();

    void setServerMessage(org.example.www.service.ServerMessage serverMessage);

    org.example.www.service.ServerMessage addNewServerMessage();
    ...
}
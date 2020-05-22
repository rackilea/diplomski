// decoupling the sending logic from the formatting
// if external requirements suggest linking such functionality into the message class
// such interface would be unnecessary
public interface DatabaseDelivery {
    void sendToDatabase(long addres, byte[] messagePayload);
}
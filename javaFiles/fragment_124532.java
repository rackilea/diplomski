class AbstractMessage{
 byte[] data;
 void GenerateHeader(){
        // this method generates the message header
 }
 // Use this method to translate your 
 // business domain message into a byte array that will go    through the network
 void abstract byte[] ToByteArray(AbstractMessage);
 // Translate received data from network to a business domain message
 void abstract AbstractMessage ParseMessage(byte[] receivedData) 
}

// And then you can have your messages
class MyMessage extends AbstractMessage{
 // In this subclass, you can define how a 
 // MyMessage object is translated into a byte array 
 // and vice versa (using ToByteArray and ParseMessage methods)
}
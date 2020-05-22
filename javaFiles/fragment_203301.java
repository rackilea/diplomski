//Strategy Contract
public interface SendStrategy<F>{
    public void send(F data);
}

public class StringSender implements SendStrategy<String>{
    public void send(String data){};
}

public class ByteArraySender implements SendStrategy<byte[]>{
    public void send(byte[] data){};
}
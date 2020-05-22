import java.io.*;
class SerializationDemo implements Serializable //composite class
{
    public SerializationDemo()
    {
        d1 = new demo();
    }
    public int value = 4;
    public demo d1;
    public String purpose="DEMO";
    public int getValue(){
    return value;
    }
}
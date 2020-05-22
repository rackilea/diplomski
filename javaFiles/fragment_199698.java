public class BufferTest
{
    public static void main(String[] args)
    {
        ArrayBuffer a = new ArrayBuffer();
        ArrayBuffer aa = a.create(); // Yes
        // DynamicDrawArrayBuffer ad = a.create(); // No

        DynamicDrawArrayBuffer d = new DynamicDrawArrayBuffer();
        ArrayBuffer da = a.create(); // Yes
        DynamicDrawArrayBuffer dd = d.create(); // Yes

        Buffer b = a;
        Buffer bb = b.create(); // Yes
        //ArrayBuffer ba = b.create(); // No
    }
}

class Buffer 
{
    public Buffer create() 
    {
        // create etc...
        return this;
    }

}

class DynamicDrawArrayBuffer extends ArrayBuffer 
{
    @Override
    public DynamicDrawArrayBuffer create()
    {
        super.create();
        return this;
    }
}

class ArrayBuffer extends Buffer 
{
    @Override
    public ArrayBuffer create()
    {
        super.create();
        return this;
    }
}
ServletOutputStream outputStream; // an instance member of your Wrapper

@Override
public synchronized ServletOutputStream getOutputStream()
throws IOException
{

    if (outputStream == null)
    {
        outputStream = super.getOutputStream();
        outputStream.write(/*your injected stuff*/);
    }
    return outputStream;
}
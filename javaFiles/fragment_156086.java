while((bytesRead = audioInputStream.read(rawByteBuffer, 0, 1024)) != -1)
{
    for (int i = 0, n = bytesRead / 2); i < n; i ++)
    {
        pcmBuffer[i] =  ( rawByteBuffer[i * 2] & 0xff )
                        | ( rawByteBuffer[(i * 2) + 1)] << 8 ) ;
    }
}
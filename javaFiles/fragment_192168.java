package aytos.util.gestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.UUID;    

public class ManagedMemoryStringBuilder implements Serializable
{
  private static final long serialVersionUID = 1L;

  private static String tmpPath;

  private StringBuilder buffer = new StringBuilder();

  private File tmpFile;

  private static int MAX_BUFFER = 262144;// 256KB

  static
  {
    // get temporal path to store the file
    tmpPath = /* TODO initialize your temporal path here */;
    if(!"".equals(tmpPath))
    {
      tmpPath += File.separator + "ManagedMemoryStringBuilder";
      File folder = new File(tmpPath);
      if(!folder.exists())
      {
        if(!folder.mkdirs())
        {
          tmpPath = "";
        }
      }
    }
  }

  public static void setTmpPath(String tmpPath1)
  {
    tmpPath = tmpPath1;
  }

  public static String getTmpPath()
  {
    return tmpPath;
  }

  public File getFile()
  {
    return tmpFile;
  }

  public ManagedMemoryStringBuilder append(String content)
  {
    if(tmpFile != null)
    {// already on disk
      writeToDisk(content);
    }
    else if(!"".equals(tmpPath) && ((buffer.length() + content.length()) > MAX_BUFFER))
    {// buffer overflow, write to disk
      flushToDisk();
      writeToDisk(content);
    }
    else
    {// great, can store in memory
      buffer.append(content);
    }
    return this;
  }

  public ManagedMemoryStringBuilder append(InputStream is)
  {
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      // attemp to fill the whole buffer
      char[] cBuf = new char[MAX_BUFFER - buffer.length()];
      int read = reader.read(cBuf);
      buffer.append(cBuf);

      if(read != -1)
      {// something is left on the reader, so we have to flush the buffer to disk and resume writing
        flushToDisk();
        ReadableByteChannel in = null;
        FileChannel out = null;
        try
        {
          in = Channels.newChannel(is);
          out = new FileOutputStream(tmpFile,true).getChannel();
          ByteBuffer bytebuf = ByteBuffer.allocateDirect(MAX_BUFFER);

          while(in.read(bytebuf) > 0)
          { // Read data from Channel into ByteBuffer
            // flip the buffer which set the limit to current position, and position to 0.
            bytebuf.flip();
            out.write(bytebuf); // Write data from ByteBuffer to file
            bytebuf.clear(); // For the next read
          }
        }
        finally
        {
          if(in != null)
          {
            try
            {
              in.close();
            }
            catch(IOException e)
            {
              // nothing to do
            }
          }
          if(out != null)
          {
            try
            {
              out.close();
            }
            catch(IOException e)
            {
              // nothing to do
            }
          }
        }
      }
      return this;
    }
    catch(IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  public ManagedMemoryStringBuilder append(ManagedMemoryStringBuilder content)
  {
    if(!"".equals(tmpPath) && content.tmpFile != null)
    {// content already on disk
      if(tmpFile == null)
      {// have to tranfer to disk
        flushToDisk();
      }
      try
      {
        FileChannel in = null;
        FileChannel out = null;
        try
        {
          in = new FileInputStream(content.tmpFile).getChannel();
          out = new FileOutputStream(tmpFile,true).getChannel();
          ByteBuffer bytebuf = ByteBuffer.allocateDirect(MAX_BUFFER);

          while(in.read(bytebuf) > 0)
          { // Read data from file into ByteBuffer
            // flip the buffer which set the limit to current position, and position to 0.
            bytebuf.flip();
            out.write(bytebuf); // Write data from ByteBuffer to file
            bytebuf.clear(); // For the next read
          }
        }
        finally
        {
          if(in != null)
          {
            try
            {
              in.close();
            }
            catch(IOException e)
            {
              // nothing to do
            }
          }
          if(out != null)
          {
            try
            {
              out.close();
            }
            catch(IOException e)
            {
              // nothing to do
            }
          }
        }
      }
      catch(IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    else
    {
      append(content.toString());
    }
    return this;
  }

  private void flushToDisk()
  {
    tmpFile = new File(tmpPath + File.separator + UUID.randomUUID());
    writeToDisk(buffer.toString());
    buffer = null;
  }

  private void writeToDisk(String content)
  {
    try
    {
      Writer output = null;
      try
      {
        output = new BufferedWriter(new FileWriter(tmpFile.getCanonicalPath(),true),MAX_BUFFER);
        output.write(content);
      }
      finally
      {
        if(output != null)
        {
          try
          {
            output.close();
          }
          catch(IOException io)
          {
            // Nothing to do
          }
        }
      }
    }
    catch(Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  public boolean isFile()
  {
    return tmpFile != null;
  }

  @Override
  public String toString()
  {
    try
    {
      if(isFile())
      {
        FileInputStream fis = new FileInputStream(tmpFile.getCanonicalPath());
        FileChannel fc = fis.getChannel();
        MappedByteBuffer mmb = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size());
        byte[] buffer str = new byte[(int)fc.size()];
        mmb.get(buffer);
        fis.close();
        fc.close();
        return new String(str);
      }
      else
      {
        return buffer.toString();
      }
    }
    catch(Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
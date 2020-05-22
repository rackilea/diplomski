package com.test.transformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipTransformer
  extends AbstractMessageTransformer
{
  private static final Logger log = LoggerFactory.getLogger(ZipTransformer.class);
  public static final int DEFAULT_BUFFER_SIZE = 32768;
  public static byte[] MAGIC = { 'P', 'K', 0x3, 0x4 };

  public ZipTransformer()
  {
    registerSourceType(InputStream.class);
    registerSourceType(byte[].class);
  }

  public Object transformMessage(MuleMessage message, String outputEncoding)
    throws TransformerException
  {
    Object payload = message.getPayload();
    try{
        byte[] data;
        if (payload instanceof byte[])
        {
            data = (byte[]) payload;
        }
        else if (payload instanceof InputStream) {
            data = IOUtils.toByteArray((InputStream)payload);
        } 
        else if (payload instanceof String)
        {
            data = ((String) payload).getBytes(outputEncoding);
        }
        else
        {
            data = muleContext.getObjectSerializer().serialize(payload);
        }
        return compressByteArray(data);
    }catch (Exception ioex)
    {
        throw new TransformerException(this, ioex);
    }
  }

  public Object compressByteArray(byte[] bytes) throws IOException
  {
      if (bytes == null || isCompressed(bytes))
      {
          if (logger.isDebugEnabled())
          {
              logger.debug("Data already compressed; doing nothing");
          }
          return bytes;
      }

      if (logger.isDebugEnabled())
      {
          logger.debug("Compressing message of size: " + bytes.length);
      }

      ByteArrayOutputStream baos = null;
      ZipOutputStream  zos = null;

      try
      {
          baos = new ByteArrayOutputStream(DEFAULT_BUFFER_SIZE);
          zos = new ZipOutputStream(baos);
          zos.putNextEntry(new ZipEntry("test.txt"));
          zos.write(bytes, 0, bytes.length);
          zos.finish();
          zos.close();

          byte[] compressedByteArray = baos.toByteArray();

          baos.close();
          if (logger.isDebugEnabled())
          {
              logger.debug("Compressed message to size: " + compressedByteArray.length);
          }

          return compressedByteArray;
      }
      catch (IOException ioex)
      {
          throw ioex;
      }
      finally
      {
          IOUtils.closeQuietly(zos);
          IOUtils.closeQuietly(baos);
      }
  }

  public boolean isCompressed(byte[] bytes) throws IOException
  {
      if ((bytes == null) || (bytes.length < 4 ))
      {
          return false;
      }
      else
      {
          for (int i = 0; i < MAGIC.length; i++) {
                if (bytes[i] != MAGIC[i]) {
                 return false;
                }
          }
          return true;
      }
  }


}
create or replace and compile java source named "ErrorMessage" 
as 
  import java.util.zip.Inflater;
  import java.lang.Byte;
  import java.sql.Blob;

  public class ErrorMessage {
    public static String uncompressMessage( Blob data, int uncompressedLength ){
      String uncompData2 = null;
      try{
        final long size = data.length();
        final byte[] cdata = data.getBytes( 0L, (int) size );
        Inflater inflater = new Inflater();
        inflater.setInput( cdata );
        byte[] uncompData = new byte[uncompressedLength];
        int n = inflater.inflate(uncompData);
        uncompData2 = new String( uncompData, "UTF-8" );
        inflater.end();
      }catch (Exception e){
        e.getMessage();
      }
      return uncompData2;
    }
}
/

create or replace function getErrorMessage(msgdata blob, msgdatalength number) return varchar2
as language java
name 'ErrorMessage.uncompressMessage(java.sql.Blob,int) return java.lang.String';
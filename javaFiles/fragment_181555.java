public class ZipFileTest {

   public static void main( String[] args ) throws IOException {
      byte[] b = "Help me please".getBytes( "UTF-8" );
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try( ZipOutputStream zos = new ZipOutputStream( baos ) ) {
         ZipEntry out = new ZipEntry( "1 First" );
         zos.putNextEntry( out );
         zos.write( b, 0, b.length );
         zos.closeEntry();
      }

      byte[] a = baos.toByteArray();        //compressed array
      ByteArrayInputStream bais = new ByteArrayInputStream( a );

      try( ZipInputStream zis = new ZipInputStream( bais ) ) {
         for( ZipEntry zipe; (zipe = zis.getNextEntry()) != null; ) {
            byte[] data = new byte[1024];
            int length = zis.read( data, 0, data.length );
            System.out.println( "Entry: " + zipe.toString() );
            System.out.println( "Data: " + new String( data, 0, length, "UTF-8" ) );
            zis.closeEntry();
         }
      }
   }
}
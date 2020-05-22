import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PNGChunkRemover
{  
     /** PNG signature constant */
     private static final long SIGNATURE = 0x89504E470D0A1A0AL;
     /** PNG Chunk type constants, 4 Critical chunks */
     /** Image header */
     private static final int IHDR = 0x49484452;   // "IHDR"
     /** Image data */
     private static final int IDAT = 0x49444154;   // "IDAT"
    /** Image trailer */
     private static final int IEND = 0x49454E44;   // "IEND"
     /** Palette */
     private static final int PLTE = 0x504C5445;   // "PLTE"

     //Ancillary chunks keys
     private static String[] KEYS = { "TRNS", "GAMA","CHRM","SRGB","ICCP","TEXT","ZTXT",
                                      "ITXT","BKGD","PHYS","SBIT","SPLT","HIST","TIME"};

     private static int[]  VALUES = {0x74524E53,0x67414D41,0x6348524D,0x73524742,0x69434350,0x74455874,0x7A545874,
                                     0x69545874,0x624B4744,0x70485973,0x73424954,0x73504C54,0x68495354,0x74494D45};

     private static HashMap<String, Integer> TRUNK_TYPES = new HashMap<String, Integer>()
     {{ 
         for(int i=0;i<KEYS.length;i++)
           put(KEYS[i],VALUES[i]);
     }};

     private static HashMap<Integer, String> REVERSE_TRUNK_TYPES = new HashMap<Integer,String>()
     {{ 
         for(int i=0;i<KEYS.length;i++)
           put(VALUES[i],KEYS[i]);
     }};

     private static Set<Integer> REMOVABLE = new HashSet<Integer>();

     private static void remove(InputStream is, File dir, String fileName) throws Exception
     {
         //Local variables for reading chunks
          int data_len = 0;
          int chunk_type = 0;
          byte[] buf=null;

          DataOutputStream ds = new DataOutputStream(new FileOutputStream(new File(dir,fileName))); 

          long signature = readLong(is);

          if (signature != SIGNATURE)
          {
              System.out.println("--- NOT A PNG IMAGE ---");
              return;
          }

          ds.writeLong(SIGNATURE);

          /** Read header */
          /** We are expecting IHDR */
          if ((readInt(is)!=13)||(readInt(is) != IHDR))
          {
              System.out.println("--- NOT A PNG IMAGE ---");
              return;
          }

          ds.writeInt(13);//We expect length to be 13 bytes
          ds.writeInt(IHDR);

          buf = new byte[13+4];//13 plus 4 bytes CRC
          is.read(buf,0,17);
          ds.write(buf);

          while (true)
          {
                data_len = readInt(is);
                chunk_type = readInt(is);
                //System.out.println("chunk type: 0x"+Integer.toHexString(chunk_type));

                if (chunk_type == IEND)
                {
                   System.out.println("IEND found");
                   ds.writeInt(data_len);
                   ds.writeInt(IEND);
                   int crc = readInt(is);
                   ds.writeInt(crc);
                   break;
                }
                if(REMOVABLE.contains(chunk_type))
                {
                    System.out.println(REVERSE_TRUNK_TYPES.get(chunk_type)+"Chunk removed!");
                    is.skip(data_len+4);
                }
                else
                {
                    buf = new byte[data_len+4];
                    is.read(buf,0, data_len+4);
                    ds.writeInt(data_len);
                    ds.writeInt(chunk_type);
                    ds.write(buf);
                }
          }
          is.close();
          ds.close();
     }

     private static int readInt(InputStream is) throws Exception
     {
         byte[] buf = new byte[4];
         int bytes_read = is.read(buf,0,4);
         if(bytes_read<0) return IEND; 
         return (((buf[0]&0xff)<<24)|((buf[1]&0xff)<<16)|
                                ((buf[2]&0xff)<<8)|(buf[3]&0xff));
     }

     private static long readLong(InputStream is) throws Exception
     {
         byte[] buf = new byte[8];
         int bytes_read = is.read(buf,0,8);
         if(bytes_read<0) return IEND; 
         return (((buf[0]&0xffL)<<56)|((buf[1]&0xffL)<<48)|
                                ((buf[2]&0xffL)<<40)|((buf[3]&0xffL)<<32)|((buf[4]&0xffL)<<24)|
                                  ((buf[5]&0xffL)<<16)|((buf[6]&0xffL)<<8)|(buf[7]&0xffL));
     }

     public static void main(String args[]) throws Exception
     {
        if(args.length>0)
        {
          File[] files = {new File(args[0])};
          File dir = new File(".");

          if(files[0].isDirectory())
          {
             dir = files[0];

             files = files[0].listFiles(new FileFilter(){
                public boolean accept(File file)
                {
                   if(file.getName().toLowerCase().endsWith("png")){
                      return true;
                   }
                   return false;
                }
             }
            );
          }     

          if(args.length>1)
          { 
             FileInputStream fs = null;

             if(args[1].equalsIgnoreCase("all")){
                REMOVABLE = REVERSE_TRUNK_TYPES.keySet();
             }
             else
             {
                String key = "";
                for (int i=1;i<args.length;i++)
                {
                    key = args[i].toUpperCase();
                    if(TRUNK_TYPES.containsKey(key))
                      REMOVABLE.add(TRUNK_TYPES.get(key));
                }
             }
             for(int i= files.length-1;i>=0;i--)
             {
                String outFileName = files[i].getName();
                outFileName = outFileName.substring(0,outFileName.lastIndexOf('.'))
                    +"_slim.png";
                System.out.println("<<"+files[i].getName());
                fs = new FileInputStream(files[i]);
                remove(fs, dir, outFileName);
                System.out.println(">>"+outFileName);   
                System.out.println("************************");
             }
          }
        }
     }
}
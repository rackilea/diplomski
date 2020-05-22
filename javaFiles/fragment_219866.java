import java.io.*;

public class RemoveGamma
{  
     /** PNG signature constant */
     public static final long SIGNATURE = 0x89504E470D0A1A0AL;
     /** PNG Chunk type constants, 4 Critical chunks */
     /** Image header */
     private static final int IHDR = 0x49484452;   // "IHDR"
     /** Image data */
     private static final int IDAT = 0x49444154;   // "IDAT"
    /** Image trailer */
     private static final int IEND = 0x49454E44;   // "IEND"
     /** Palette */
     private static final int PLTE = 0x504C5445;   // "PLTE"
     /** 14 Ancillary chunks */
     /** Transparency */
     private static final int tRNS = 0x74524E53;   // "tRNs"
    /** Image gamma */
     private static final int gAMA = 0x67414D41;   // "gAMA"
     /** Primary chromaticities */
     private static final int cHRM = 0x6348524D;   // "cHRM"
     /** Standard RGB color space */
     private static final int sRGB = 0x73524742;   // "sRGB"
     /** Embedded ICC profile */
     private static final int iCCP = 0x69434350;   // "iCCP"
     /** Textual data */
     private static final int tEXt = 0x74455874;   // "tEXt"
     /** Compressed textual data */
     private static final int zTXt = 0x7A545874;   // "zTXt"
     /** International textual data */
     private static final int iTXt = 0x69545874;   // "iTXt"
     /** Background color */
     private static final int bKGD = 0x624B4744;   // "bKGD"
     /** Physical pixel dimensions */
     private static final int pHYs = 0x70485973;   // "pHYs"
     /** Significant bits */
     private static final int sBIT = 0x73424954;   // "sBIT"
     /** Suggested palette */
     private static final int sPLT = 0x73504C54;   // "sPLT"
     /** Palette histogram */
     private static final int hIST = 0x68495354;   // "hIST"
     /** Image last-modification time */
     private static final int tIME = 0x74494D45;   // "tIME"

     public void remove(InputStream is) throws Exception
     {
         //Local variables for reading chunks
          int data_len = 0;
          int chunk_type = 0;
          long CRC = 0;
          byte[] buf=null;

          DataOutputStream ds = new DataOutputStream(new FileOutputStream("temp.png")); 

          long signature = readLong(is);

          if (signature != SIGNATURE)
          {
              System.out.println("--- NOT A PNG IMAGE ---");
              return;
          }

          ds.writeLong(SIGNATURE);

          //*******************************
          //Chuncks follow, start with IHDR
          //*******************************
          /** Chunk layout
              Each chunk consists of four parts:

              Length
                 A 4-byte unsigned integer giving the number of bytes in the chunk's data field.
                 The length counts only the data field, not itself, the chunk type code, or the CRC.
                 Zero is a valid length. Although encoders and decoders should treat the length as unsigned, 
                 its value must not exceed 2^31-1 bytes.

              Chunk Type
                 A 4-byte chunk type code. For convenience in description and in examining PNG files, 
                 type codes are restricted to consist of uppercase and lowercase ASCII letters 
                 (A-Z and a-z, or 65-90 and 97-122 decimal). However, encoders and decoders must treat 
                 the codes as fixed binary values, not character strings. For example, it would not be
                 correct to represent the type code IDAT by the EBCDIC equivalents of those letters. 
                 Additional naming conventions for chunk types are discussed in the next section.

              Chunk Data
                 The data bytes appropriate to the chunk type, if any. This field can be of zero length.

              CRC
                 A 4-byte CRC (Cyclic Redundancy Check) calculated on the preceding bytes in the chunk,
                 including the chunk type code and chunk data fields, but not including the length field. 
                 The CRC is always present, even for chunks containing no data. See CRC algorithm. 
            */

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

                switch (chunk_type)
                {
                   case gAMA://or any non-significant chunk you want to remove
                   {
                       System.out.println("gamma found");
                       is.skip(data_len+4);
                       break;
                   }
                   default:
                   {
                       buf = new byte[data_len+4];
                       is.read(buf,0, data_len+4);
                       ds.writeInt(data_len);
                       ds.writeInt(chunk_type);
                       ds.write(buf);
                       break;
                   }
                }
            }
            is.close();
            ds.close();
     }

     private int readInt(InputStream is) throws Exception
     {
         byte[] buf = new byte[4];
         is.read(buf,0,4);
         return (((buf[0]&0xff)<<24)|((buf[1]&0xff)<<16)|
                                ((buf[2]&0xff)<<8)|(buf[3]&0xff));
     }

     private long readLong(InputStream is) throws Exception
     {
         byte[] buf = new byte[8];
         is.read(buf,0,8);
         return (((buf[0]&0xffL)<<56)|((buf[1]&0xffL)<<48)|
                                ((buf[2]&0xffL)<<40)|((buf[3]&0xffL)<<32)|((buf[4]&0xffL)<<24)|
                                  ((buf[5]&0xffL)<<16)|((buf[6]&0xffL)<<8)|(buf[7]&0xffL));
     }

     public static void main(String args[]) throws Exception
     {
        FileInputStream fs = new FileInputStream(args[0]);
        RemoveGamma rg = new RemoveGamma();
        rg.remove(fs);       
     }
}
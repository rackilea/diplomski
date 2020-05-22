package common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SerializeTools {

static public byte[] changePathInSerializedFile(File f, String fromPath, String toPath) throws IOException {
    byte[] buffer = new byte[(int)f.length()];
    FileInputStream in = new FileInputStream(f);
    in.read(buffer);
    in.close();
    return SerializeTools.changePathInSerializedData(buffer,fromPath,toPath);
}

static public byte[] changePathInSerializedData(byte[] buffer, String fromPath, String toPath) throws IOException {
    byte[] search = fromPath.getBytes("UTF-8");
    byte[] replace = toPath.getBytes("UTF-8");

    ByteArrayOutputStream f = new ByteArrayOutputStream();

    for (int i=0;i<buffer.length;i++) {
        //Search 2 bytes ahead to let us modify the 2 bytes length of the class name (see Serialize format http://www.javaworld.com/community/node/2915 )
        boolean found=false;
        int searchMaxIndex=i+search.length+2;
        if (searchMaxIndex<=buffer.length) {
            found=true;
            for (int j=i+2;j<searchMaxIndex;j++) {
                if (search[j-i-2]!=buffer[j]) {
                    found=false;
                    break;
                }
            }
        }
        if (found) {
            int high=((int)(buffer[i])&0xff);
            int low=((int)(buffer[i+1])&0xff);
            int classNameLength=(high<<8)+low;
            classNameLength+=replace.length-search.length;
            //Write new length
            f.write((classNameLength>>8)&0xff);
            f.write((classNameLength)&0xff);
            //Write replacement path
            f.write(replace);
            i=searchMaxIndex-1;
        } else {
            f.write(buffer[i]);
        }
    }

    f.flush();
    f.close();

    return f.toByteArray();
}

}
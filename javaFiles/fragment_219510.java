public class TftpPacket {

// Opcodes
protected static final short RRQ=1;
protected static final short WRQ=2;
protected static final short DATA=3;
protected static final short ACK=4;
protected static final short ERROR=5;
protected static final String BLOCKSIZE = "blksize";

byte []packet;
int lenght;

/**
 *  Builds a view to a byte array as a tftp packet.
 *  The original byte array is the one manipulated by all methods
 */
public TftpPacket( byte []data, int len ) {
    packet = data;
    lenght = len;
}

/**
 *  Gets number at first two bytes of packet
 */
public int getOpcode() {
    return (packet[0]<<8)|(packet[1]&0xff);  //net byte order = Big-Endian
}

/**
 *  Sets first two bytes of packet
 */
public void setOpcode(int code) {
    packet[0] = (byte) ((code>>8)&0xff);
    packet[1] = (byte) (code&0xff);
}

/**
 *  Gets string starting at byte 2
 */
public String getFileName() {
    int i;
    for ( i=2; i<lenght; i++ )
        if (packet[i]==0) //end of string
            return new String(packet, 2, i-2);
    return null;
}

/**
 *  Sets two strings (NUL terminated) starting at byte 2
 */
public void setFilename( String s, String mode, String blockSize ) {
    byte []a = s.getBytes();
    int i,j,k;
    for ( i=0; i+2<lenght && i<a.length; i++ ) {
        packet[i+2] = a[i];
    }
    packet[i+2] = 0;
    a = mode.getBytes();
    for ( j=0,i++; i<lenght && j<a.length; i++,j++ ) {
        packet[i+2] = a[j];
    }
    packet[i+2] = 0;

    a = BLOCKSIZE.getBytes();
    for ( k=0,i++; i<lenght && k<a.length; i++,k++ ) {
        packet[i+2] = a[k];
    }
    packet[i+2] = 0;

    a = blockSize.getBytes();
    for ( k=0,i++; i<lenght && k<a.length; i++,k++ ) {
        packet[i+2] = a[k];
    }
    packet[i+2] = 0;

}

/**
 *  Gets second string in packet
 */
public String getMode(){
    for ( int i=2; i<lenght; i++ )
        if (packet[i]==0) { //end of 1st string
            for ( int j=i+2; j<lenght; j++ )
                if ( packet[j]==0 ) return new String(packet, i+1, j-i-1);
        }
    return null; 
}

/**
 *  Gets number at bytes 2 and 3 of packet (can be block count or error code)
 */
public int getBlockCount() {
    return (packet[2]<<8)|(packet[3]&0xff);  //net byte order = Big-Endian
}

/**
 *  Sets bytes 2 and 3 of packet (can be block count or error code)
 */
public void setBlockCount(int count) {
    packet[2] = (byte) ((count>>8)&0xff);
    packet[3] = (byte) (count&0xff);
}

/**
 *  Sets string (NUL-terminated) starting at byte 4
 */
public void setErrMsg( String s ) {
    byte []a = s.getBytes();
    int i;
    for ( i=0; i<a.length; i++ ) {
        packet[i+4] = a[i];
    }
    packet[i+4] = 0;
}
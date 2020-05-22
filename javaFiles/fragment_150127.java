byte[] bytes = new byte[2048];   
int bitGet;   
unsigned int dwords[] = new unsigned int[2046];

public BitArray() {   
    for (int i=0; i<bytes.length; ++i) {   
        bytes[i] = (byte) i;   
    }   

    for (int i= 0; i<dwords.length; ++i) {
        dwords[i]= 
            (bytes[i    ] << 24) | 
            (bytes[i + 1] << 16) | 
            (bytes[i + 2] <<  8) | 
            (bytes[i + 3]);
    }
}   

int getBits(int len)
{
    int offset= bitGet;
    int offset_index= offset>>4;
    int offset_offset= offset & 15;

    return (dwords[offset_index] >> offset_offset) & ((1 << len) - 1);
}
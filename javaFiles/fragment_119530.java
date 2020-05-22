byte[]a=intToFourBytes(width);
bytes[18]=a[3];
bytes[19]=a[2];
bytes[20]=a[1];
bytes[21]=a[0];

a=intToFourBytes(height);
bytes[22]=a[3];
bytes[23]=a[2];
bytes[24]=a[1];
bytes[25]=a[0];
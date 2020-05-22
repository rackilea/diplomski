src = array of byte with length (RawHdr.Width * RawHdr.Height * 4)
dst = array of byte with the same length

dstindex = 0

for (i = RawHdr.Height - 1; i >= 0; i--)
    {
     srcstartindex = i * RawHdr.Width * 4;
     for (j = 0; j < RawHdr.Width; j++)
         {  
           si = srcstartindex + j * 4;
           dst[dstindex] = src[si + 2];
           dst[dstindex + 1] = src[si + 1];
           dst[dstindex + 2] = src[si];
           dst[dstindex + 3] = src[si + 3];
           dstindex +=4;
         }
     }
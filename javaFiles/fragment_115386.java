if( dataLength ) ...

int readBytes = 0;

while( readBytes < dataLength )
{
   readBytes += in.read( data, readBytes, dataLength-readBytes);
}

if( dataLength ) ...
private final static int STOP_AT_BYTE = 8192;   //how far to search for thumbnail
private final static int THUMB_MAX_SIZE = 16284; 

private Image getThumbnailFromStream(InputStream str, long fileSize)
{
    byte[] tempByteArray = new byte[THUMB_MAX_SIZE]; // how big can a thumb get.
    byte[] bytefileReader = {0}; // lazy byte reader
    byte firstByte,secondByte = 0;
    int currentIndex = 0;

    int currByte = 0;

    try {
        str.read(bytefileReader);
        firstByte = bytefileReader[0];
        str.read(bytefileReader);
        secondByte = bytefileReader[0];

        currByte += 2;

        if ((firstByte & 0xFF) == 0xFF && (secondByte & 0xFF) == 0xD8) {    //if this is JPEG
            byte rByte = 0;
            do {
                while (rByte != -1 && currByte < fileSize) {
                    str.read(bytefileReader);
                    rByte = bytefileReader[0];
                    currByte++;
                }

                str.read(bytefileReader);
                rByte = bytefileReader[0];
                currByte++;

                if (currByte > STOP_AT_BYTE) {
                    return null;
                }
            } while ((rByte & 0xFF) != 0xD8 && currByte < fileSize); // thumb starts

            if (currByte >= fileSize) {
                return null;
            }

            tempByteArray[currentIndex++] = -1;
            tempByteArray[currentIndex++] = rByte;
            rByte = 0;

            do {
                while (rByte != -1){
                    str.read(bytefileReader);
                    rByte = bytefileReader[0];
                    tempByteArray[currentIndex++] = rByte;
                }

                str.read(bytefileReader);
                rByte = bytefileReader[0];
                tempByteArray[currentIndex++] = rByte;
            } while ((rByte & 0xFF) != 0xD9); // thumb ends

            tempByteArray[currentIndex++] = -1;
            Image image = Image.createImage(tempByteArray, 0, currentIndex-1);
            tempByteArray = null;

            return image;
        }
    } catch (Throwable e) {
        //error
    }

    return null;
}
// Header
short serial = buffer.getShort();
byte[] fileNameB = new byte[255];
buffer.get(fileNameB);
// If 0 terminated asciz string:
int len = fileNameB.length;
for (int i = 0; i < fileNameB.length; ++i) {
    if (fileNameB[i] == 0) {
        len = i;
        break;
    }
}
String fileName = new String(fileNameB, 0, len, StandardCharsets.ISO_8859_1);

short date = buffer.getShort();
short fieldNumbers = buffer.getShort();
short numbersOfRecords = buffer.getShort();

for (int fieldI = 0; fieldI < fieldNumber; ++fieldI) {
    // Info about Fields 
    short fieldCode = buffer.getShort();
    //byte fieldName: ShortString;   //1 byte
}
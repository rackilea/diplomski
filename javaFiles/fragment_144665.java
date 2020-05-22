// as mentioned in the comments, user wants specifically 4 arrays
byte[][] byteArrays = byte[4][]; //

Set<String> finalPathNames = sharedpre.getStringSet("prePathNames", null);
InputStream is = null;
int index = 0;
for (String temp : finalPathNames) {
    byteArrays[index] = new byte[0]; // in case of exception clear array. possibly set to null
    try {
        is = new FileInputStream(temp);
        try {
            byte[] byteArray  = streamToBytes(is);
            byteArrays[index] = byteArray;
        } finally {
            is.close();
        }
    } catch (Exception e) { 

    }
    finally {
        index++;
    }
}
InputStreamReader isr = new InputStreamReader(uc.getInputStream());
int numCharsRead;
char[] charArray = new char[1024];

while ((numCharsRead = isr.read(charArray)) > 0) {
    //Apply my criteria here on the stream
}
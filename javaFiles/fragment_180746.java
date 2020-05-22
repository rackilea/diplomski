Reader fileReader = new InputStreamReader(input, "UTF-8");

int charsRead;
char buf[] = new char[256];

while ((charsRead = fileReader.read(buf)) > 0) {
   //You have charsRead characters in a buffer here
}
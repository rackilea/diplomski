int BUFFER_SIZE=1024;
char[] buffer = new char[BUFFER_SIZE]; // or some other size, 
int charsRead = 0;
while ( (charsRead  = rd.read(buffer, 0, BUFFER_SIZE)) != -1) {
  sb.append(buffer, 0, charsRead);
}
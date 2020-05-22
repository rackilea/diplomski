final int CHUNK_SIZE = 3;
final int BUFFER_SIZE = 8192; // explicit buffer size is better
File file = ...
InputStream is = new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);
Reader rdr = new BufferedReader(new InputStreamReader(is), BUFFER_SIZE);
char buff = new char[CHUNK_SIZE];
int len;
while ((len = rdr.read(buff)) != -1) {
   // buff[0] through buff[len-1] are valid
}
rdr.close();
String filePath = "/sdcard/utf8_file.txt";
String UTF8 = "utf8";
int BUFFER_SIZE = 8192;

BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), UTF8),BUFFER_SIZE);
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), UTF8),BUFFER_SIZE);
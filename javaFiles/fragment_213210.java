FileInputStream fis = new FileInputStream(file);
int c;
String temp = "";
while ( (c = fis.read()) != -1) {
     temp = temp + " | " + Character.toString((char) c);
}
Log.v(TAG, temp);
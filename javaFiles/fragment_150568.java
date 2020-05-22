AssetManager assetManager = getAssets(); 
String[] files = assetManager.list("Files");
InputStream input = assetManager.open("helloworld.txt");
int size = input.available();
byte[] buffer = new byte[size];
input.read(buffer);
input.close();
String text = new String(buffer);
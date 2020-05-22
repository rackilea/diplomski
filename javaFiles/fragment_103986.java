private static final int BUFFER_SIZE = 1024;

...

byte[] buffer = new byte[BUFFER_SIZE];
int len1 = 0;
Log.v("Place", "Download started!");
int on = 0;
while ((len1 = is.read(buffer,0,BUFFER_SIZE)) != -1) {
    fos.write(buffer, 0, len1);
    Log.v("is", "running "  + len1);
}

...
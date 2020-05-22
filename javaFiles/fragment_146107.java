File dest = Environment.getExternalStorageDirectory();
InputStream in = context.getResources().openRawResource(R.raw.file);
// Used the File-constructor
OutputStream out = new FileOutputStream(new File(dest, "file.zip"));

// Transfer bytes from in to out
byte[] buf = new byte[1024];
int len;
try {
    // A little more explicit
    while ( (len = in.read(buf, 0, buf.length)) != -1){
         out.write(buf, 0, len);
    }
} finally {
    // Ensure the Streams are closed:
    in.close();
    out.close();
}
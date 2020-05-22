// Download a file to /data/data/your.app/files
new DownloadFile(ctxt, "http://yourfile", ctxt.openFileOutput("destinationfile.ext", Context.MODE_PRIVATE));

// Copy a file from raw resource to the files directory as above
InputStream in = ctxt.getResources().openRawResource(R.raw.myfile);
OutputStream out = ctxt.openFileOutput("filename.ext", Context.MODE_PRIVATE);
final ReadableByteChannel ic = Channels.newChannel(in);
final WritableByteChannel oc = Channels.newChannel(out);
DownloadFile.fastChannelCopy(ic, oc);
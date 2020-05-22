private boolean InstallmyAPK(){

AssetManager assetManager = getAssets();
InputStream in = null;
OutputStream out = null;
File myAPKFile = new File(Environment.getExternalStorageDirectory().getPath()+"/myAPKFile.apk");

try {

    if(!myAPKFile.exists()){
        in = assetManager.open("myAPKFile.apk");
        out = new FileOutputStream(myAPKFile);

        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }

        in.close();
        in = null;

        out.flush();
        out.close();
        out = null;
    }

    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setDataAndType(Uri.fromFile(myAPKFile),
            "application/vnd.android.package-archive");
    startActivity(intent);
    return true;

} catch(Exception e) {return false;}

}
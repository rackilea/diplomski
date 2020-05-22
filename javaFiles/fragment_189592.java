public class InstallAPKActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ExtFilter apkFilter = new ExtFilter("apk");
        File file[] = Environment.getExternalStorageDirectory().listFiles(apkFilter);
        Log.d("InstallApk", "Filter applied. Size: "+ file.length);

        for (int i=0; i < file.length; i++)
        {
            Log.d("InstallApk", "FileName:" + file[i].getName());
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file[i]), "application/vnd.android.package-archive");
            startActivity(intent);
        }





    }

    class ExtFilter implements FilenameFilter { 
        String ext; 
        public ExtFilter(String ext) { 
            this.ext = "." + ext; 
        } 
        public boolean accept(File dir, String name) { 
            return name.endsWith(ext); 
        }
    }
}
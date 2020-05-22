private void getDir(String dirPath)
{
    myPath.setText("Location: " + dirPath);
    item = new ArrayList<String>();
    path = new ArrayList<String>();
    File f = new File(dirPath);
    File[] files = f.listFiles();

    if(!dirPath.equals(root))
    {
        item.add(root);
        path.add(root);
        item.add("../");
        path.add(f.getParent());
    }
    if (files.length!=0) {
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (!file.isHidden() && file.canRead()) {
                path.add(file.getPath());
                if (file.isDirectory()) {
                    item.add(file.getName() + "/");
                } else {
                    item.add(file.getName());
                }
            }
        }
    }
    ArrayAdapter<String> fileList =
            new ArrayAdapter<String>(this, R.layout.row, item);
    setListAdapter(fileList);
}
    @Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myPath = (TextView)findViewById(R.id.path);

    root = Environment.getExternalStorageDirectory().getPath();
    if (!checkPermissions()) {
        requestPermissions();
    } else {


        getDir(root);
    }

}
/**
 * this method request to permission asked.
 */

private void requestPermissions() {
    boolean shouldProvideRationale =
            ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE);

    if (shouldProvideRationale) {
    } else {
        Log.i("Error", "Requesting permission");
        // previously and checked "Never ask again".
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_PERMISSIONS_REQUEST_CODE);
    }
}
private void getDir(String dirPath)
{
    myPath.setText("Location: " + dirPath);
    item = new ArrayList<String>();
    path = new ArrayList<String>();
    File f = new File(dirPath);
    File[] files = f.listFiles();

    if(!dirPath.equals(root))
    {
        item.add(root);
        path.add(root);
        item.add("../");
        path.add(f.getParent());
    }
    if (files.length!=0) {
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (!file.isHidden() && file.canRead()) {
                path.add(file.getPath());
                if (file.isDirectory()) {
                    item.add(file.getName() + "/");
                } else {
                    item.add(file.getName());
                }
            }
        }
    }
    ArrayAdapter<String> fileList =
            new ArrayAdapter<String>(this, R.layout.row, item);
    setListAdapter(fileList);
}
/**
 * this method check permission and return current state of permission need.
 */
private boolean checkPermissions() {
    int permissionState = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.READ_EXTERNAL_STORAGE);
    return permissionState == PackageManager.PERMISSION_GRANTED;
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
        if (grantResults.length <= 0) {
            // If user interaction was interrupted, the permission request is cancelled and you
            // receive empty arrays.
            Log.i("Error", "User interaction was cancelled.");
        } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission was granted. Kick off the process of building and connecting
            // GoogleApiClient.
            getDir();//define path
        } else {
        }
    }

}
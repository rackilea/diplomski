public class MainActivity extends AppCompatActivity {

private Button b;
private ImageView iv;

private final int PICTURE_ACTIVITY_CODE = 1;
private File captured_image_file;
private boolean flag = false;
private boolean flag_1 = false;
private String file_name = "myphoto";
private String file_extension = "png";



@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    iv = (ImageView) findViewById(R.id.iv);

    b = (Button) findViewById(R.id.b);

    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            createDirectoryChooserDialog();
        }
    });

}

private void createDirectoryChooserDialog() {

    File mPath = new File(Environment.getExternalStorageDirectory() + "//DIR//");
    FileDialog fileDialog = new FileDialog(this, mPath, "." + "png");

    fileDialog.addDirectoryListener(new FileDialog.DirectorySelectedListener() {
        public void directorySelected(File directory) {
            Log.e(getClass().getName(), "*********selected dir " + directory.toString());

            if (!directory.toString().isEmpty()) {
                if (directory.exists()) {

                    captured_image_file = new File(directory.getAbsolutePath() + "/" + file_name + "." + file_extension);

                    flag = true;

                } else {

                    flag = false; // directory doesn't exits.
                }
            }

            if (flag) {
                if (!captured_image_file.exists()) { // file doesn't exist
                    Log.e("File doesn't exists", "Creating File");
                    try {
                        flag_1 = captured_image_file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        flag_1 = false;
                    }
                } else {
                    flag_1 = true; // file will be over-written
                }
                if (flag_1) {
                    Log.e("Creation", "Succeeded");
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Uri outputFileUri = Uri.fromFile(captured_image_file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                    startActivityForResult(intent, PICTURE_ACTIVITY_CODE);
                }
            }
        }
    });
    fileDialog.setSelectDirectoryOption(true);
    fileDialog.showDialog();

}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == PICTURE_ACTIVITY_CODE) {
        if (resultCode == RESULT_OK) {
            Uri inputFileUri = Uri.fromFile(captured_image_file);
            Bitmap image = BitmapFactory.decodeFile(inputFileUri.getPath());
            iv.setImageBitmap(image);
        } else {
            // handle partially created file
        }
    }
}

}
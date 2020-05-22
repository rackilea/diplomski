public class MainActivity extends Activity {

ListView lv;
ArrayAdapter<MyFile> adapter;

public void list() {

    lv = (ListView) findViewById(R.id.listView1);

    File dir = new File(Environment.getExternalStorageDirectory().getPath()
            + "/osmdroid/tiles/");
    File[] filelist = dir.listFiles();
    ArrayList<MyFile> theNamesOfFiles = new ArrayList<MyFile>();
    for (File temp : filelist) {
        theNamesOfFiles.add(new MyFile(temp));
    }
    Collections.sort(theNamesOfFiles, new Comparator<MyFile>() {

        @Override
        public int compare(MyFile lhs, MyFile rhs) {
            return lhs.toString().compareToIgnoreCase(rhs.toString());
        }
    });
    adapter = new ArrayAdapter<MyFile>(this, R.layout.list_row,
            theNamesOfFiles);

    lv.setAdapter(adapter);
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);

    list();

    lv.setOnItemLongClickListener(new OnItemLongClickListener() {
        // setting onItemLongClickListener and passing the position to the
        // function
        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                int position, long arg3) {

            doDeleteFile(adapter.getItem(position).file);

            return true;
        }
    });
}

public void doDeleteFile(File fileToDelete) {
    if (!fileToDelete.isDirectory()) {

        try {
            if (fileToDelete.delete()) {

                System.out.println("File delete operation success");
            }

            else {
                System.out.println("File delete operation failed");
            }
        } catch (Exception ex) {
            System.out.println("Exception :" + ex.getMessage());
        }

    } else {

        System.out.println("It is  not a file");

    }

}

public class MyFile {
    File file;
    String fileName;

    public MyFile(File file)
    {
        this.file = file;
        this.fileName = file.getName();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
    }

    @Override
    public String toString() {
        return this.fileName;
    }
}
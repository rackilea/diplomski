public class DirectoryBrowser extends ListActivity {

private List<String> items = null;
private File currentDirectory;
private ArrayAdapter<String> fileList;

@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    currentDirectory = new File("/sdcard/textfile");
    getFiles(currentDirectory.listFiles());

}

@Override
protected void onListItemClick(ListView l, View v, int position, long id){
    int selectedRow = (int)id;

        currentDirectory = new File(items.get(selectedRow));
        if(currentDirectory.isDirectory()){
            getFiles(currentDirectory.listFiles());
        }else{
            //if the selected file is not a directory. get the filename
            currentDirectory.getPath();
        }
}

private void getFiles(File[] files){
    items = new ArrayList<String>();
    for(File file : files){
        items.add(file.getPath());
    }
    fileList = new ArrayAdapter<String>(this,R.layout.list_text, items);
    setListAdapter(fileList);
}


}
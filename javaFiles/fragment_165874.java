File dir = new File(Environment.getExternalStorageDirectory() + "/myapp/" + "/Media/");
if (dir.isDirectory()) {
    String[] children = dir.list();
//if there are files to delete inside the folder
    if(children.length>0){
        Toast.makeText(appActivity.this, "done", Toast.LENGTH_SHORT).show();
    }
//if there are no files inside the folder
    else{
        Toast.makeText(appActivity.this, "No files to delete", Toast.LENGTH_SHORT).show(); 
    }
    for (int i = 0; i < children.length; i++) {
        new File(dir, children[i]).delete();

    }



}
else{
    Toast.makeText(appActivity.this, "No Such directory exists", Toast.LENGTH_SHORT).show();
}
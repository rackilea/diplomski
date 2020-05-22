void imageload () {
FileDialog fd = new FileDialog(MainFram.this,"Open", FileDialog.LOAD);
fd.show();
if(fd.getFile() == null){
//Label1.setText("You have not chosen any image files yet");
}
else{

String d = (fd.getDirectory() + fd.getFile());
//Toolkit toolkit = Toolkit.getDefaultToolkit();
//Image1 = toolkit.getImage(d);`
//Object saveImage=Image1;
insertImage(d) //Db function
int num = 0;
String save = at.getText().toString() + ".jpg";
File file = new File(myDir, save);
while(file.exists()) {
    save = at.getText().toString() + (num++) +".jpg";
    file = new File(myDir, save); 
}
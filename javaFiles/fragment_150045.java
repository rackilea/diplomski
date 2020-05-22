// use "File.separator" instead of "/"
File file = new File(Environment.getExternalStorageDirectory() + File.separator + "test.txt");

//create the file
file.createNewFile();

//text you want to write to your file
String text = "your_text";

//check if file exists
if(file.exists()){
    OutputStream fo = new FileOutputStream(file);

    //write the data
    fo.write(text);

    //close to avoid memory leaks
    fo.close();

    //give a log message that the file was created with "text"
    System.out.println("file created: "+file);
}
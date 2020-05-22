public void fileCreate(Context context, String fileDir) throws Exception{

    File myNewDir = context.getDir(fileDir, Context.MODE_PRIVATE);
    if (!myNewDir.exists()){
        myNewDir.mkdirs();
    }


    File testContnet = new File(myNewDir, "hello_file.txt");
    String hello = "Hello world";
    FileOutputStream fos = new FileOutputstream(testContnet);
    fos.write(hello.getBytes());
    fos.flush();
    fos.getFD().sync();
    fos.close();
}
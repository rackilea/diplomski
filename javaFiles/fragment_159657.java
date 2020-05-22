class MyMockContext extends MockContext {

    @Override
    public File getFilesDir(){
        File f = new     
          File("/data/user/0/com.example.mypackagename/files");
        return f;
    }
}
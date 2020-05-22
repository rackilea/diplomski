public void convertESPtoJPG()
{
    //initialize ImageMagick operation
    IMOperation op = new IMOperation();

    //setting my path allows us to use ImageMagicks "convert" vs. Windows "convert"
    String myPath="C:\\Program Files\\ImageMagick-6.8.9-Q16";
    ProcessStarter.setGlobalSearchPath(myPath);

    op.addImage(); //in
    op.addImage(); //out
    ConvertCmd cmd = new ConvertCmd();

    //filter out files for eps files, and load the files using included FilenameLoader
    ExtensionFilter filter = new ExtensionFilter("eps");
    FilenameLoader  loader = new FilenameLoader(filter);
    List<String> files = loader.loadFilenames("C:\\Program Files\\ImageMagick-6.8.9- 
Q16\\NakedWines\\Raw\\");

    //what we plan on converting our eps files to
    FilenamePatternResolver resolver = new FilenamePatternResolver("%P/%f.jpg");

    //iterate through loaded files
    for (String img: files)
    {
        try {
            //execute our convert commands
            cmd.run(op,img,resolver.createName(img));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
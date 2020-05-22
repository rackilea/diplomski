public void writeFileOnInternalStorage(Context mcoContext,String sFileName, String sBody){      
    File file = new File(mcoContext.getFilesDir(),"mydir");
    if(!file.exists()){
        file.mkdir();
    }

    try{
        File gpxfile = new File(file, sFileName);
        FileWriter writer = new FileWriter(gpxfile);
        writer.append(sBody);
        writer.flush();
        writer.close();

    }catch (Exception e){
        e.printStackTrace();

    }
}
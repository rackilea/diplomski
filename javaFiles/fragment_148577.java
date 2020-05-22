String value = "test.VBS";
for (File checkedFile : listOfFiles){
    if (checkedFile.isFile()){
        files = checkedFile.getName();

        if(files.equals(value)){
            //Do this
        } else {
            // Do this
        }
    }
}
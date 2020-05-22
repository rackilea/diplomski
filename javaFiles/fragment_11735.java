void generateCode(){
    for(int i = 0; i < counts; i++){
        generateFileType(desc[i], ext[i]);  

    }
}

public void generateFileType(String a, String...b){
        fe = new FileNameExtensionFilter(a, b);


    session.addChoosableFileFilter(fe);
}
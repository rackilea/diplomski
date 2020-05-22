for(int i=0;i < ReadFile.maxLine();i++){ 
     // data[i][0] = ReadFile.lineLengths();
        data[i][1] = ReadFile.getFileStartingTime() ;
        data[i][2] = ReadFile.getFileEndingTime();
        data[i][3] = ReadFile.readSubtitles() ;
}
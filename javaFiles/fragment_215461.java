for (String file: fileNames){                   //logically OK
    String url = path + file;                 
    for (int i = 0; i < urls.length; i++) {     //things start going wrong
        urls[i] = url;                          //this line has a red underline
    }
}
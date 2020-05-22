TessBaseAPI baseApi = new TessBaseAPI();
    baseApi.setPageSegMode(TessBaseAPI.OEM_TESSERACT_CUBE_COMBINED);
    baseApi.setPageSegMode(PageSegMode.PSM_AUTO_OSD);
    baseApi.setPageSegMode(PageSegMode.PSM_SINGLE_LINE);
    baseApi.setDebug(true);
    baseApi.init(DATA_PATH, lang);
    //set variable
    String whiteList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String blackList = "\\s";
    baseApi.setVariable(TessBaseAPI.VAR_CHAR_WHITELIST, whiteList);
    baseApi.setVariable(TessBaseAPI.VAR_CHAR_BLACKLIST, blackList);
    //setImage
    //baseApi.setImage(bmpOtsu, w, h, 8, (Integer) null);
    baseApi.setImage(bmpOtsu);
    //variable for recognizing      
    String recognizedText = baseApi.getUTF8Text();
    recognizedText = recognizedText.replaceAll(blackList, "");//remove space
    String resultTxt = recognizedText;
    //
    baseApi.end();

    Log.v(TAG, "OCRED TEXT: " + recognizedText);
    if ( lang.equalsIgnoreCase("eng") ) {
        int get8digits = recognizedText.indexOf("D");
        String loop = recognizedText.substring(get8digits, recognizedText.length());
        if(recognizedText.contains("D") && loop.length() >= 8){
            Log.w(TAG, "OPSI 1"+"\n"+"Length: "+loop.length()+"\n"+"Values: "+loop);                
            recognizedText = recognizedText.substring(get8digits, get8digits+8);                                                
        }else if(recognizedText.contains("D") && loop.length() < 8){
            Log.w(TAG, "OPSI 2"+"\n"+"Length: "+loop.length()+"\n"+"Values: "+loop);
            recognizedText = loop;
        }else{
            Log.w(TAG, "OPSI 3"+"\n"+"Length: "+loop.length()+"\n"+"Values: "+loop);
            recognizedText = recognizedText.replaceAll("[A-Z0-9]"," ");

        }
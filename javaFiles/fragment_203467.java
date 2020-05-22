import java.net.URLDecoder;


    try {  
    if(!d.isNull(CURSOR_FIRST_NAME)){cm.first = URLDecoder.decode(d.getString(CURSOR_FIRST_NAME, "UTF-8");}    
    } catch (UnsupportedEncodingException e) {
    Log.("UnsupportedEncodingException ", e.getMessage());
    }
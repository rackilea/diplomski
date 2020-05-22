public String get(String key) {
    if(dictBundle.containsKey(key)) {           
        if (isDesktop) {
            try {
                return new String(dictBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return dictBundle.getString(key);
    }
    return key;
}
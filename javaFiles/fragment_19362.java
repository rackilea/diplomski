String[] strings = request.getParameterValues("multi");
if (strings != null) {
    if (response.getCharacterEncoding().equals("ISO-8859-1")) {
        for (int i=0; i<strings.length; i++) {
            strings[i] = URLDecoder.decode(new String(strings[i].getBytes("ISO-8859-1"), "UTF-8"), "UTF-8");
        }
    }
    for (String s: strings) {
        // do whatever you want with correctly encoded special characters
    }
}
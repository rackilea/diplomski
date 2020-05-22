public String withoutX(String str) {   
    if (str == null) { 
        return null;
    }

    if (str.startsWith("x")) {
        str = str.substring(1);
    }
    if (str.endsWith("x")) {
        str = str.substring(0, str.length()-1);
    }

    return str;
}
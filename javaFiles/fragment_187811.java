public static normalize(String string) {
    string = string.toLowerCase();
    //Remove/change all special characters -->  àaç is converted to aac

    String temp = Normalizer.normalize(string, Normalizer.Form.NFD);
    string = pattern.matcher(temp).replaceAll("");
    //Remove extra spaces  
    string = StringUtils.normalizeSpace(string);
}
public static String unObify(String param) {

    String deleteOB = param.replaceAll("OB(?=[AEIOU])", "");

    return deleteOB;

}
/**
 * @param fullLongString Long String value
 * @param maxLengthOfPart Maximum length of the smaller String 
 * @return String result as a short String
 */
public static String getShortString(String fullLongString, int maxLengthOfPart) {

    if((fullLongString == null) || (fullLongString.trim().equals("")) || (maxLengthOfPart <= 0) || (fullLongString.length() <= maxLengthOfPart)) {
        return fullLongString;
    } else {
       String firstPart = fullLongString.substring(0, maxLengthOfPart);
       return firstPart + "\n" + getShortString(fullLongString.substring(maxLengthOfPart, fullLongString.length()),maxLengthOfPart);
    }

}
public static String toProperCase(String s)
{
    // You might want to check if the string is empty before
    if(Character.isUpperCase(s.charAt(0))) {
      return s;
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
}
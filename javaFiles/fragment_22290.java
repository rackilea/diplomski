/** In reality, you would probably read file to string? 
 * or read line by line? either way is an easy fix! 
*/

String input = ("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\"style=\"width:100%\">");
String xmlTag = StringUtils.substringBetween(input, "<", ">");